# Proyecto Cliente-Servidor con Sockets en Java

Este proyecto implementa un sistema básico de comunicación entre un **Cliente** y un **Servidor** utilizando sockets en Java. El cliente envía mensajes al servidor y el servidor responde según un conjunto de reglas predefinidas. El objetivo principal es practicar el uso de **Sockets** para la comunicación en red.

## Descripción

En este proyecto, el cliente se conecta al servidor mediante un socket en el puerto `5000`. El servidor recibe mensajes y responde de acuerdo a un flujo de interacción preestablecido.

### Flujo de interacción:

1. **Cliente** envía el mensaje: `¿Quién es?`
   - **Servidor** responde: `Soy yo`

2. **Cliente** responde cualquier mensaje, excepto `¿Qué vienes a buscar?`
   - **Servidor** responde: `Error`

3. **Cliente** envía el mensaje: `¿Qué vienes a buscar?`
   - **Servidor** responde: `A ti`

4. **Cliente** envía el mensaje: `Ya es tarde`
   - **Servidor** responde: `¿Por qué?`

5. **Cliente** responde: `Porque ahora soy yo la que quiere estar sin ti`
   - **Servidor** responde: `Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta`
   - La comunicación se corta.

6. En cualquier otra situación, el servidor responderá con un mensaje de error: `Error`.

## Requisitos

- **Java 8** o superior.
- Conexión de red local (puede ser en un entorno local usando `127.0.0.1` o con otros dispositivos conectados a la misma red).

## Estructura del Proyecto

- **Cliente.java**: Código fuente que implementa el cliente.
- **Servidor.java**: Código fuente que implementa el servidor.

![image](https://github.com/user-attachments/assets/885f3b1a-015b-4329-b14d-94a6192d9d32)

