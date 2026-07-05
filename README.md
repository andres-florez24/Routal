<<<<<<< HEAD
# Routal
programa contable de mensajería 
=======
﻿Routal — Sistema de Validación y Orquestación de Datos RPA (Holcim)

Proyecto de práctica que simula el rol de soporte RPA en Holcim: orquestación de datos,
validación automática, generación de incidentes y reportería.

📌 Contexto

Este sistema simula un flujo real de soporte RPA:


Un orquestador (n8n / Power Automate) captura mensajes de Telegram con datos de domicilios.
El backend en Java recibe, valida y persiste esa información.
Se compara contra una fuente maestra de control en Google Sheets.
Si hay discrepancias o fallas, se genera automáticamente un incidente en ServiceNow.
Los datos consolidados alimentan un dashboard en Power BI y una interfaz web en React.


🏗️ Arquitectura

Backend construido en Java Spring Boot siguiendo Arquitectura Hexagonal estricta,
con principios SOLID, DRY y KISS:

org.example.rpa
├── domain            → Modelos puros de negocio, sin dependencias externas
│   ├── model         → Entidades y Value Objects (ReporteDomicilio, MetodoPago, etc.)
│   └── parser        → Traducción de datos externos hacia el dominio
├── application       → Reglas de orquestación, sin frameworks
│   ├── port          → Interfaces/contratos (Puertos)
│   └── usecase       → Casos de uso que orquestan los puertos
└── infrastructure    → Implementaciones concretas (Adaptadores)
├── persistence   → JPA + MySQL
├── web           → Controllers REST (pendiente)
└── clients       → Google Sheets / ServiceNow (pendiente)

Principio clave: el Dominio y la Aplicación son Java puro — no conocen Spring, JPA,
ni ningún framework. Solo la Infraestructura depende de tecnologías externas, gracias a la
Inversión de Dependencias (los Puertos son interfaces que la Infraestructura implementa).

🧱 Stack tecnológico

CapaTecnologíaOrquestación / ETLn8n / Power AutomateBackendJava Spring Boot (Hexagonal, SOLID, DAO/JPA)Base de datos relacionalMySQLFuente maestra de controlGoogle Sheets (API)Gestión de incidentesServiceNow (API REST)FrontendReact (JavaScript, HTML, CSS)BI / ReporteríaPower BI

📋 Reglas de negocio centrales


Recepción: el orquestador captura el mensaje de Telegram, lo limpia y lo envía como JSON al backend.
Comparación: el backend guarda el dato en MySQL y valida que el domicilio y la empresa existan en la base maestra (Google Sheets).
Notificación: si hay discrepancias o falla la automatización, se registra el error en MySQL y se crea automáticamente un ticket en ServiceNow.
Reportería: se generan reportes consolidados (día, mes, año) accesibles para Power BI.
Interfaz: el frontend en React permite consultar domicilios, empresas, estado del orquestador y una bitácora de errores.


✅ Estado actual


Capa de Dominio (modelos puros + parseo)
Capa de Aplicación (Puertos + Caso de Uso)
Persistencia MySQL (entidad JPA, mapper, repositorio, adaptador) — conectado y probado
Adaptador de validación contra Google Sheets
Adaptador de notificación de incidentes vía ServiceNow
Controller REST para recibir datos del orquestador
Frontend en React
Dashboard en Power BI


🗄️ Esquema de base de datos

Base de datos: rpa_domicilios
Tabla: reportes_telegram

ColumnaTipoDetalleidINTPK, auto_incrementalclienteVARCHARentregaVARCHARrecogidaVARCHARmetodo_pagoVARCHARvalorINTfecha_registroTIMESTAMPdefault current_timestamp

🚀 Cómo ejecutar el proyecto


Levanta MySQL (por ejemplo, vía XAMPP) y crea la base rpa_domicilios con la tabla reportes_telegram.
Configura src/main/resources/application.properties con tus credenciales de MySQL.
Ejecuta la clase principal RoutalApplication.java desde IntelliJ (▶ Run).
Verifica en consola: Started RoutalApplication in X.XXX seconds.
>>>>>>> db764ff (feat: estructura base de Arquitectura Hexagonal, dominio y persistencia JPA)
