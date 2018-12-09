

# Build

mvn clean package

# Docker Build

docker build . -t cviniciusdr/duff-machine:1.0

# Docker Run

docker run -p 8080:8080 cviniciusdr/duff-machine:1.0