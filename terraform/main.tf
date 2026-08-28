terraform {
  required_version = ">= 1.15.0"

  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "4.5.0"
    }
  }
}

provider "docker" {}

variable "ansible_public_key" {
  description = "Public SSH key installed on the managed target"
  type        = string
  sensitive   = true
}

resource "docker_image" "ansible_target" {
  name = "gilded-rose-ansible-target:terraform"

  build {
    context = "${path.module}/../ansible/target"

    build_args = {
      ANSIBLE_PUBLIC_KEY = var.ansible_public_key
    }
  }

  triggers = {
    dockerfile_sha1 = filesha1("${path.module}/../ansible/target/Dockerfile")
    public_key_sha1 = sha1(var.ansible_public_key)
  }
}

resource "docker_network" "gilded_rose" {
  name = "gilded-rose-terraform-net"
}

resource "docker_container" "target" {
  name  = "gilded-rose-terraform-target"
  image = docker_image.ansible_target.image_id

  networks_advanced {
    name = docker_network.gilded_rose.name
  }

  ports {
    internal = 22
    external = 2223
  }
}

output "target_name" {
  value = docker_container.target.name
}

output "network_name" {
  value = docker_network.gilded_rose.name
}

output "ssh_port" {
  value = 2223
}