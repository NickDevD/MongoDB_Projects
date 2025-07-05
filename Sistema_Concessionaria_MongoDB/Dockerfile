# Usar uma imagem base oficial do OpenJDK para Java 22 (conforme correção anterior)
FROM openjdk:22-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR executável do seu projeto para o diretório de trabalho do container
COPY target/Sistema_Concessionaria_MongoDB-1.0-SNAPSHOT.jar app.jar

# Copiar o arquivo .env para o diretório de trabalho do container
COPY .env .env

# Expor a porta que sua aplicação pode estar usando (se aplicável, para APIs ou Web Apps)
# EXPOSE 8080

# Comando para executar a aplicação quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]