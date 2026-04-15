# ChickenFarm Organizr

English version below

Ein modernes **Spring Boot**-basiertes Verwaltungssystem für eine Hühnerfarm.  
Mit diesem Tool kannst du Hühner, Gruppen, Eierproduktion und Impfungen übersichtlich verwalten und protokollieren.


---

## Funktionen

Hühner verwalten  
  - Anlegen neuer Hühner mit Rasse, Geschlecht, Geburtsdatum etc.
  - Zuordnung zu Gruppen
  - Aktualisieren (z. B. Todesdatum)

Gruppenverwaltung 
  - Erstellen und Verwalten von Hühnergruppen

Eiererfassung  
  - Eier pro einzelnem Huhn erfassen (Größe, Datum, Uhrzeit)
  - Eier pro Gruppe erfassen (Menge)

Impfverwaltung  
  - Impfungen einzelner Hühner dokumentieren (Wirkstoff, Menge, Datum, Uhrzeit)

Gruppenwechsel & Historie 
  - Hühner zwischen Gruppen verschieben
  - Vollständige Historie aller Ereignisse (Eintritt, Austritt, Eier, Impfungen)

Frontend  
  - React + Material-UI Oberfläche
  - Formulare zum einfachen Eintragen
  - Übersichtstabellen mit DataGrid

---

## Technologie-Stack

Backend
- Spring Boot 3.2.2
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- REST API mit DTOs

Frontend
- React
- Material-UI (MUI)
- Day.js (für Datums- und Zeit-Picker)
- Axios / Fetch API

Sonstiges
- Maven Wrapper
- Cross-Origin Support (`@CrossOrigin`)

---

## Projektstruktur

ChickenFarmOrganisation/
* ├── ChickenfarmOrganizr/              ← Backend (Spring Boot)
* │   ├── src/main/java/com/ChickenFarm/ChickenfarmOrganizr/
* │   ├── pom.xml
* │   └── mvnw / mvnw.cmd
* │
* ├── Studentsystem/studentfrontend/    ← Frontend (React)
* │   ├── src/components/
* │   ├── public/
* │   └── package.json
* │
* ├── UMLDiagrammChickenfarm            ← Datenbank-Diagramm
* └── README.md


---

## Installation & Start

1. Voraussetzungen
 - Java 17 oder höher
 - PostgreSQL Datenbank
 - Node.js (für das Frontend)
 - Maven

2. Backend starten
 bash

 - cd ChickenfarmOrganizr

 Datenbank-Konfiguration in application.properties anpassen
 (Standard: localhost:5432 mit Benutzer/Passwort anpassen)
 +
 - ./mvnw spring-boot:run

 Backend läuft standardmäßig auf: http://localhost:8080

3. Frontend starten
 - cd ChickenFrontend/ChickenReactFrontend
 - npm install
 - npm start

 Frontend läuft standardmäßig auf: http://localhost:3000

---

 ## Wichtige API-Endpunkte

| Methode | Endpoint                              | Beschreibung                          |
|---------|---------------------------------------|---------------------------------------|
| POST    | `/chicken/add`                        | Neues Huhn anlegen                    |
| GET     | `/chicken/getAll`                     | Alle Hühner abrufen                   |
| POST    | `/eggs/addEggChicken`                 | Ei eines einzelnen Huhns hinzufügen   |
| POST    | `/eggs/addEggGroup`                   | Eier einer ganzen Gruppe hinzufügen   |
| POST    | `/vaccinations/addOneVaccination`     | Impfung eines Huhns hinzufügen        |
| POST    | `/groupOfChickenChange/add`           | Huhn in eine andere Gruppe wechseln   |
| GET     | `/group/getAll2`                      | Alle Gruppen abrufen                  |

---

## Datenbank

Das Projekt verwendet **PostgreSQL**.  
Ein Entity-Relationship-Diagramm (UML) befindet sich im Ordner `ChickenFarmProjekt`.

Wichtige Tabellen:

- `chicken`
- `group`
- `eggs`
- `vaccination`
- `group_of_chicken_change`
- `history`

---
 ## ToDo / Offene Punkte

- [ ] Dokumentengenerator (`DocumentGenerator.java`)
- [ ] Erweiterte Historienansicht im Fronten
- [ ] Authentifizierung / Login-System
- [ ] Export-Funktionen (PDF / Excel)
---
## Lizenz

Dieses Projekt ist nur für **private und Bildungszwecke** gedacht.



ChickenFarm Organizr
A modern Spring Boot-based management system for a chicken farm.
This tool allows you to efficiently manage chickens, groups, egg production, and vaccinations in a structured and transparent way.

Features
Chicken Management


Add new chickens with breed, gender, date of birth, etc.


Assign chickens to groups


Update records (e.g., death date)


Group Management


Create and manage chicken groups


Egg Tracking


Record eggs per individual chicken (size, date, time)


Record eggs per group (quantity)


Vaccination Management


Document vaccinations for individual chickens (vaccine, dosage, date, time)


Group Transfers & History


Move chickens between groups


Full history tracking of all events (entry, exit, eggs, vaccinations)


Frontend


React + Material UI interface


Simple input forms for data entry


Overview tables using DataGrid



Technology Stack
Backend


Spring Boot 3.2.2


Spring Data JPA


PostgreSQL


Maven


Lombok


REST API with DTOs


Frontend


React


Material UI (MUI)


Day.js (for date and time pickers)


Axios / Fetch API


Others


Maven Wrapper


Cross-Origin support (@CrossOrigin)



Project Structure
ChickenFarmOrganisation/
├── ChickenfarmOrganizr/              # Backend (Spring Boot)
│   ├── src/main/java/com/ChickenFarm/ChickenfarmOrganizr/
│   ├── pom.xml
│   └── mvnw / mvnw.cmd
├── Studentsystem/studentfrontend/    # Frontend (React)
│   ├── src/components/
│   ├── public/
│   └── package.json
├── UMLDiagrammChickenfarm            # Database diagram
└── README.md

Installation & Setup
Requirements


Java 17 or higher


PostgreSQL database


Node.js


Maven



Backend Setup
cd ChickenfarmOrganizr
Configure your database in application.properties
(Default: localhost:5432)
Start backend:
./mvnw spring-boot:run
Backend runs on:
http://localhost:8080

Frontend Setup
cd ChickenFrontend/ChickenReactFrontendnpm installnpm start
Frontend runs on:
http://localhost:3000

API Endpoints
MethodEndpointDescriptionPOST/chicken/addCreate a new chickenGET/chicken/getAllGet all chickensPOST/eggs/addEggChickenAdd egg for a chickenPOST/eggs/addEggGroupAdd eggs for a groupPOST/vaccinations/addOneVaccinationAdd vaccination for a chickenPOST/groupOfChickenChange/addMove chicken to another groupGET/group/getAll2Get all groups

Database
The project uses PostgreSQL.
Tables


chicken


group


eggs


vaccination


group_of_chicken_change


history



TODO


 Document generator (DocumentGenerator.java)


 Extended history view in frontend


 Authentication / login system


 Export features (PDF / Excel)



License
This project is intended for private and educational purposes only.
