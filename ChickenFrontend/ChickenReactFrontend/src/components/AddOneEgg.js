


import * as React from 'react';
import {Paper, Button } from '@material-ui/core';
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
export default function FormPropsTextFields() {

    const[ecoID, setEocID] = useState('');
const[dateOfPutEgg, setDateOfPutEgg] = useState('');
const[timeOfPutEgg, setTimeOfPutEgg] = useState('');
const[size, setSize] = useState('') ;

const [chicken, setChicken] = useState([]);

const [selectedOptionOfEggOfChicken, setSelectedOptionOfEggOfChicken] = useState(null);


const [selectedDate, setSelectedDate] = useState(null);
const [chickenName, setChickenName] = useState('');


const handleChangeEggOfChicken = event => {
     setSelectedOptionOfEggOfChicken(event.target.value);
    setChickenName(event.target.value);

  };


  const handleDateChangeEgg = (date) => {

    setSelectedDate(date);

    const timestamp = date;
  
  const dateObj = new Date(date);
  const day = dateObj.getDate();
  const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
  const year = dateObj.getFullYear();
  
  const formattedDate = `${day}.${month}.${year}`;
  
    setDateOfPutEgg(formattedDate);
  
  };

  const [selectedTimeOfEgg, setSelectedTime] = useState(null);

  const handdleChangeTime = (selectedTimeOfEgg) => {

      setSelectedTime(selectedTimeOfEgg);

      const formattedTime = selectedTimeOfEgg ? dayjs(selectedTimeOfEgg).format('HH:mm:ss') : '';

      setTimeOfPutEgg(formattedTime);

  }


  const [eggSize, setEggSize] = React.useState('');
  
  const handleChangeEggSize = (event) => {
    setEggSize(event.target.value);
    setSize(event.target.value);
  };


const buttonToAddOneEgg = (e) => {
    
    e.preventDefault();
    
      const newEgg = {timeOfPutEgg , dateOfPutEgg, size, chickenName} ;    
    
      console.log(newEgg);
    
      fetch("http://localhost:8080/eggOfChicken/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEgg)
      
      }).then(() => {
        console.log("New chicken added");
      });


    


    }


 useEffect(() => {
    fetch("http://localhost:8080/chicken/getAll")
     .then(res => res.json())
     .then(result => {
       setChicken(result);
       });
   }, []);




return(

<Paper elevation={5} style={styles.paperStyle2}>


<h1 style={{ color: "black" }}><u>Ein Huhn hat ein neues Ei gelegt</u></h1>

<div style={styles.containerStyle}>



<FormControl fullWidth>

<InputLabel id="demo-dynamic-select-label">Huhn</InputLabel>

<Select
    labelId="demo-dynamic-select-label"
    id="demo-dynamic-select"
    value={selectedOptionOfEggOfChicken}
    label="Ei des Huhns"
    onChange={handleChangeEggOfChicken}
    sx={{color:'black'}}
> 

{chicken.map(chicken => (
<MenuItem key={chicken.chickenID} value={chicken.chickenName}>
{chicken.chickenName}
</MenuItem>
))}
</Select>



</FormControl>



<FormControl fullWidth>
      <InputLabel id="demo-simple-select-label">Größe</InputLabel>
      <Select
        labelId="demo-simple-select-label"
        id="demo-simple-select"
        value={size}
        label="Größe"
        onChange={handleChangeEggSize}
      >
        <MenuItem value={"S"}>S</MenuItem>
        <MenuItem value={"M"}>M</MenuItem>
        <MenuItem value={"L"}>L</MenuItem>
      </Select>
    </FormControl>

<LocalizationProvider dateAdapter={AdapterDayjs}>
<DemoContainer components={['DatePicker']}>
<DatePicker 
label="An welchem Tag wurde das Ei gelegt" 
value={selectedDate}
onChange={handleDateChangeEgg}
/>
</DemoContainer>


</LocalizationProvider>

    <LocalizationProvider dateAdapter={AdapterDayjs}>
        <DemoContainer components={['TimePicker']}>
            <TimePicker
                label="Uhrzeit Ei gelegt"
                value={selectedTimeOfEgg}
                onChange={handdleChangeTime}
                ampm={false}
            />
        </DemoContainer>
    </LocalizationProvider>

<Button
    variant="contained"
    color="black" // corrected color
    onClick={buttonToAddOneEgg }
  >
   Ei Hinzufügen
</Button>
  
  </div>
  
</Paper>

);

}