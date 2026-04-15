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

-----------------------------------------------------------------


# ChickenFarm Organizr

**English Version**

A modern **Spring Boot**-based management system for a chicken farm.  
With this tool you can clearly manage chickens, groups, egg production and vaccinations.

---

## Features

- **Chicken Management**
  - Create new chickens with breed, gender, date of birth, etc.
  - Assign chickens to groups
  - Update chicken data (e.g. date of death)

- **Group Management**
  - Create and manage chicken groups

- **Egg Recording**
  - Record eggs from individual chickens (size, date, time)
  - Record eggs from an entire group (quantity)

- **Vaccination Management**
  - Document vaccinations of individual chickens (active ingredient, dosage, date, time)

- **Group Changes & History**
  - Move chickens between groups
  - Complete history of all events (entry, exit, eggs, vaccinations)

- **Frontend**
  - React + Material-UI interface
  - Easy-to-use forms
  - Overview tables with DataGrid

---

## Technology Stack

### Backend
- Spring Boot 3.2.2
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- REST API with DTOs

### Frontend
- React
- Material-UI (MUI)
- Day.js (for date and time pickers)
- Axios / Fetch API

### Others
- Maven Wrapper
- Cross-Origin Support (`@CrossOrigin`)

---

## Project Structure

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

## Installation & Getting Started

### 1. Prerequisites
- Java 17 or higher
- PostgreSQL database
- Node.js (for the frontend)
- Maven

### 2. Start Backend

bash
- cd ChickenfarmOrganizr

 - Adjust database configuration in application.properties
 (Default: localhost:5432 with username/password)

- ./mvnw spring-boot:run


### 3. Start Frontend

- cd Studentsystem/studentfrontend
- npm install
- npm start
---
## Important API Endpoints

| Method | Endpoint                              | Description                              |
|--------|---------------------------------------|------------------------------------------|
| POST   | `/chicken/add`                        | Add a new chicken                        |
| GET    | `/chicken/getAll`                     | Get all chickens                         |
| POST   | `/eggs/addEggChicken`                 | Add egg from a single chicken            |
| POST   | `/eggs/addEggGroup`                   | Add eggs from an entire group            |
| POST   | `/vaccinations/addOneVaccination`     | Add vaccination for one chicken          |
| POST   | `/groupOfChickenChange/add`           | Change chicken to another group          |
| GET    | `/group/getAll2`                      | Get all groups                           |
---
## Database

The project uses **PostgreSQL**.  

An Entity-Relationship Diagram (UML) can be found in the folder `ChickenFarmProjekt`.
---
### Important Tables

- `chicken`
- `group`
- `eggs`
- `vaccination`
- `group_of_chicken_change`
- `history`

---
## Todo / Open Points

- [ ] Document Generator (`DocumentGenerator.java`)
- [ ] Extended history view in the frontend
- [ ] Authentication / Login system
- [ ] Export functions (PDF / Excel)

---

## License

This project is intended for **private and educational purposes only**.


