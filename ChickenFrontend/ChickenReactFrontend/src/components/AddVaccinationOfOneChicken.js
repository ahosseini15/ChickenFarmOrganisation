


import * as React from 'react';
import {Paper, Button, Box} from '@material-ui/core';
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
import TextField from '@mui/material/TextField';
import { TimePicker } from '@mui/x-date-pickers/TimePicker';
import dayjs from 'dayjs';
import { format, parseISO } from 'date-fns';
import Slider from '@mui/material/Slider';
import Typography from '@mui/material/Typography';


export default function FormPropsTextFields() {

    const[voocId, setVoocID] = useState('');
    const[dateOfVaccination, setDateOfVaccination] = useState('');
    const[timeOfVaccination, setTimeOfVaccination] = useState('');
    const[crowdOfVaccination, setCrowdOfVaccination] = useState('') ;
    const[activeIngedient, setActiveIngedient] = useState('') ;

    const [chicken, setChicken] = useState([]);

    const [selectedOptionOfVaccinationOfChicken, setSelectedOptionOfVaccinationOfChicken] = useState(null);


    const [selectedDate, setSelectedDate] = useState(null);
    const [chickenName, setChickenName] = useState('');


    const handleChangeVaccinationOfChicken = event => {
        setSelectedOptionOfVaccinationOfChicken(event.target.value);
        setChickenName(event.target.value);

    };


    const handleDateChangeVaccination = (date) => {

        setSelectedDate(date);

        const timestamp = date;

        const dateObj = new Date(date);
        const day = dateObj.getDate();
        const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
        const year = dateObj.getFullYear();

        const formattedDate = `${day}.${month}.${year}`;

        setDateOfVaccination(formattedDate);

    };

    const [selectedTimeOfEgg, setSelectedTime] = useState(null);

    const handdleChangeTime = (selectedTimeOfEgg) => {

        setSelectedTime(selectedTimeOfEgg);

        const formattedTime = selectedTimeOfEgg ? dayjs(selectedTimeOfEgg).format('HH:mm:ss') : '';

        setTimeOfVaccination(formattedTime);

    }


    const [vaccinationCroud, setVaccinationCroud] = React.useState('');




    const MAX = 1000;
    const MIN = 0;
    const marks = [
        {
            value: MIN,
            label: '',
        },
        {
            value: MAX,
            label: '',
        },
    ];


    const [val, setVal] = React.useState(MIN);
    const handleChangeVaccinationbCroud = (_, newValue) => {
        setVal(newValue);
        setCrowdOfVaccination(newValue);
    };


    const buttonToAddOneVaccination = (e) => {

        e.preventDefault();

        const newVaccine = {timeOfVaccination: timeOfVaccination , dateOfVaccination: dateOfVaccination, crowdOfVaccination: crowdOfVaccination, chickenName, activeIngredient: activeIngedient} ;

        console.log(newVaccine);

        fetch("http://localhost:8080/vaccinationOfOneChicken/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newVaccine)

        }).then(() => {
            console.log("New vaccine added");
        });





    }


        useEffect(() => {
        fetch("http://localhost:8080/chicken/getAll")
            .then(res => res.json())
            .then(result => {
                setChicken(result);
            });
    }, []);


    //TODO Text Field
    //TODO Slider
    //TODO customize fields




    return(
        <Paper elevation={5} style={styles.paperStyle2}>


            <h1 style={{ color: "black" }}><u>Ein Huhn wurde geimpft</u></h1>

            <div style={styles.containerStyle}>



                <FormControl fullWidth>

                    <InputLabel id="demo-dynamic-select-label">Huhn</InputLabel>

                    <Select
                        labelId="demo-dynamic-select-label"
                        id="demo-dynamic-select"
                        value={selectedOptionOfVaccinationOfChicken}
                        label="Ei des Huhns"
                        onChange={handleChangeVaccinationOfChicken}
                        sx={{color:'black'}}
                    >

                        {chicken.map(chicken => (
                            <MenuItem key={chicken.chickenID} value={chicken.chickenName}>
                                {chicken.chickenName}
                            </MenuItem>
                        ))}
                    </Select>

                </FormControl>



                <Box sx={{ width: 250 }}>
                    Menge der Impfdose
                    <Slider
                        marks={marks}
                        step={50}
                        value={val}
                        valueLabelDisplay="auto"
                        min={MIN}
                        max={MAX}
                        onChange={handleChangeVaccinationbCroud}
                    />



                    <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
                        <Typography
                            variant="body2"
                            onClick={() => setVal(MIN)}
                            onClick={() => setVal(MIN)}
                            sx={{ cursor: 'pointer' }}
                        >
                             0 - 1000 µl
                        </Typography>
                        <Typography
                            variant="body2"
                            onClick={() => setVal(MAX)}
                            sx={{ cursor: 'pointer' }}
                        >

                        </Typography>
                    </Box>
                </Box>

            {
                <TextField
                    required
                    id="chickename"
                    label="Name des Impfstoffes"
                    defaultValue="MusterHuhn"
                    value={activeIngedient}
                    onChange={(e) => setActiveIngedient(e.target.value)}
                />

            }



                <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <DemoContainer components={['DatePicker']}>
                        <DatePicker
                            label="An welchem Tag wurde das Ei gelegt"
                            value={selectedDate}
                            onChange={handleDateChangeVaccination}
                        />
                    </DemoContainer>


                </LocalizationProvider>

                <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <DemoContainer components={['TimePicker']}>
                        <TimePicker
                            label="Basic time picker"
                            value={selectedTimeOfEgg}
                            onChange={handdleChangeTime}
                            ampm={false}
                        />
                    </DemoContainer>
                </LocalizationProvider>

                <Button
                    variant="contained"
                    color="black" // corrected color
                    onClick={buttonToAddOneVaccination }
                >
                    Impfung hinzufügen
                </Button>

            </div>

        </Paper>

    );

}