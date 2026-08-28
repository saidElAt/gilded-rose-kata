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

resource "docker_network" "gilded_rose" {
  name = "gilded-rose-terraform-net"
}

resource "docker_container" "target" {
  name  = "gilded-rose-terraform-target"
  image = "ubuntu:24.04"

  command = [
    "sleep",
    "infinity"
  ]

  networks_advanced {
    name = docker_network.gilded_rose.name
  }
}