# ChickenFarm Organizr

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

cd ChickenfarmOrganizr

Datenbank-Konfiguration in application.properties anpassen
(Standard: localhost:5432 mit Benutzer/Passwort anpassen)

./mvnw spring-boot:run

Backend läuft standardmäßig auf: http://localhost:8080

3. Frontend starten
cd ChickenFrontend/ChickenReactFrontend

npm install
npm start

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
