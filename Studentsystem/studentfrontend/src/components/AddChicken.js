import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Paper, Button } from '@material-ui/core';
import { useState, useEffect } from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import styles from './styles';
import {DataGrid} from "@mui/x-data-grid";

export default function FormPropsTextFields() {
    const [chickenID, setChickenID] = useState('');
    let [chickenName, setChickenName] = useState('');
    let [chickenGender, setChickenGender] = useState('');
    let [chickenDateOfBirth, setChickenDateOfBirth] = useState('');
    const [chickenDateOfDeath, setChickenDateOfDeath] = useState('');
    let [chickenRace, setChickenRace] = useState('');
    let [chickenGroupName, setChickenGroupName] = useState('');
    let i = 0;


    const buttonToAddChicken = (e) => {

        e.preventDefault();

        let newChicken = e.target.value;


        newChicken = {chickenName, chickenGender, chickenRace, chickenDateOfBirth, chickenGroupName, chickenID};


        fetch("http://localhost:8080/chicken/add", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(newChicken)

        }).then(() => {
            console.log("New chicken added");
            console.log(newChicken);
        });
    }

//////////////////////////////////////////////////////


        const buttonToAddChicken2 = (e) => {

            let newChicken2 = e.target.value;

            newChicken2 = {chickenName , chickenDateOfDeath}

            fetch("http://localhost:8080/chicken/update", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(newChicken2)

            }).then(() => {
                console.log("New chicken added");
            });

            console.log(newChicken2);
        }


    





        const[ group, setGroup] = useState([]);

        useEffect(() => {
            fetch("http://localhost:8080/group/getAll2")
             .then(res => res.json())
             .then(result => {
               setGroup(result);
               });
           }, []);






        const [selectedDate, setSelectedDate] = useState(null);
        const [selectedDate2, setSelectedDate2] = useState(null);


    const handleDateChange = (date) => {
        // Aktualisieren Sie den Zustand mit dem ausgewählten Datum
        setSelectedDate(date);
        setSelectedDate2(date)


        const timestamp = date;

        const dateObj = new Date(date);
        const day = dateObj.getDate();
        const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
        const year = dateObj.getFullYear();

        const formattedDate = `${day}.${month}.${year}`;


        setChickenDateOfBirth(formattedDate);


    }

    const handleDateChangeDeath = (date) => {
        // Aktualisieren Sie den Zustand mit dem ausgewählten Datum

        setSelectedDate2(date)




        const dateObj = new Date(date);
        const day = dateObj.getDate();
        const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
        const year = dateObj.getFullYear();

        const formattedDate = `${day}.${month}.${year}`;




        setChickenDateOfDeath(formattedDate);
    }


        const [Gender, setGender] = React.useState('');

    const handleChangeGender = (event) => {
        setGender(event.target.value);
        setChickenGender(event.target.value);

       
      }

    const [selectedOption, setSelectedOption] = useState('');
        useEffect(() => {
            fetch("http://localhost:8080/group/getAll2")
            .then(res => res.json())
            .then(result => {
             setGroup(result);
             });
             }, []);


    const [chicken, setChicken] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/chicken/getAll")
            .then(res => res.json())
            .then(result => {
                setChicken(result);
            });
    }, []);

    const selectedChickenGroup = event => {
            setSelectedOption(event.target.value);
            setChickenGroupName(event.target.value);
          };


    const [selectedOptionOfChickenUpdate, setSelectedOptionOfChickenUpdate] = useState('');

    const handleChangeChickenDeath  = event => {
        setSelectedOptionOfChickenUpdate(event.target.value);
        setChickenName(event.target.value);

    }



return (


    <Paper elevation={5} style={styles.paperStyle2}>
        <div style={styles.containerStyle}>

            <h1 style={{color: "black"}}><u>Neues Huhn anlegen</u></h1>


            <FormControl fullWidth>

                <InputLabel id="demo-dynamic-select-label">Auswahl</InputLabel>

                <Select
                    labelId="demo-dynamic-select-label"
                    id="demo-dynamic-select"
                    value={selectedOption}
                    label="Gruppe"
                    onChange={selectedChickenGroup}
                    sx={{color: 'black'}}
                >

                    {group.map(group => (
                        <MenuItem key={group.groupID} value={group.groupName}>
                            {group.groupName}
                        </MenuItem>
                    ))}
                </Select>


            </FormControl>
            {
                <TextField
                    required
                    id="chickename"
                    label="Name vom Huhn"
                    defaultValue="MusterHuhn"
                    value={chickenName}
                    onChange={(e) => setChickenName(e.target.value)}
                />

            }

            {<TextField
                required
                id="chickenrace"
                label="Rasse"
                defaultValue=""
                value={chickenRace}
                onChange={(e) => setChickenRace(e.target.value)}
            />}


            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">Geschlecht</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={Gender}
                    label="Geschlecht"
                    onChange={handleChangeGender}
                >
                    <MenuItem value={"männlich"}>männlich</MenuItem>
                    <MenuItem value={"weiblich"}>weiblich</MenuItem>

                </Select>
            </FormControl>


            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DemoContainer components={['DatePicker']}>
                    <DatePicker
                        label="Wähle das Geburtsdatum aus"
                        value={selectedDate}
                        onChange={handleDateChange}
                    />
                </DemoContainer>
            </LocalizationProvider>


            <Button
                variant="contained"
                color="black" // corrected color
                onClick={buttonToAddChicken}
            >
                Huhn anlegen
            </Button>




            <h1 style={{color: "black"}}><u>Huhn ist Gestorben</u></h1>


            <Select
                labelId="demo-dynamic-select-label"
                id="demo-dynamic-select"
                value={selectedOptionOfChickenUpdate}
                label="Ei des Huhns"
                onChange={handleChangeChickenDeath}
                sx={{color: 'black'}}
            >

                {chicken.map(chicken => (
                    <MenuItem key={chicken.chickenID} value={chicken.chickenName}>
                        {chicken.chickenName}
                    </MenuItem>
                ))}
            </Select>

            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DemoContainer components={['DatePicker2']}>
                    <DatePicker
                        label="Wähle das Todesdatum aus"
                        value={selectedDate2}
                        onChange={handleDateChangeDeath}
                    />
                </DemoContainer>

            </LocalizationProvider>

            <Button
                variant="contained"
                color="black" // corrected color
                onClick={buttonToAddChicken2}
            >
                Huhn ist gestorben
            </Button>

        </div>

    </Paper>


)

}