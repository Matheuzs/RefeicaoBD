# Projeto Refeição Banco de Dados

## Preparação do ambiente - (Fedora Linux)

#### Instalação do Docker
```bash
sudo dnf -y install dnf-plugins-core
sudo dnf config-manager --add-repo https://download.docker.com/linux/fedora/docker-ce.repo
sudo dnf install docker-ce
sudo systemctl start docker
sudo systemctl enable docker
sudo usermod -aG docker $USER
```

Reinicie sua sessão para validar as alterações

#### Instalação do Docker-Compose 
```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

#### Inicializar Postgres e PGAdmin
```bash
docker-compose down && docker-compose up -d && docker-compose logs -f
```
