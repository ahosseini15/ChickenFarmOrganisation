
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
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Slider from '@mui/material/Slider';
import MuiInput from '@mui/material/Input';
import Alert from '@mui/material/Alert';
import CheckIcon from '@mui/icons-material/Check';

export default function FormPropsTextFields() {



    const Input = styled(MuiInput)`
  width: 42px
`;
        const [value, setValue] = React.useState(30);

        const handleSliderChange = (event, newValue) => {
            setValue(newValue);
            setCroud(newValue);
        };

        const handleInputChange = (event) => {
            setValue(event.target.value === '' ? 0 : Number(event.target.value));
        };

        const handleBlur = () => {
            if (value < 0) {
                setValue(0);
            } else if (value > 100) {
                setValue(100);
            }
        };



    const[eggsOfGroupId, setEggsOfGroupId] = useState('');


const[dateOfCollectEggs, setDateOfCollectEggs] = useState('');
const[timeOfcollectEggs, setTimeOfPutEgg] = useState('');

    const [showAlert, setShowAlert] = useState(false);

const [group, setGroup] = useState([]);

const [selectedOptionOfEggOfGroup, setSelectedOptionOfEggOfGroup] = useState(null);


const [selectedDate, setSelectedDate] = useState(null);
const [groupName, setGroupName] = useState('');
const [croud, setCroud] = useState('');


const handleChangeEggOfGroup = event => {
     setSelectedOptionOfEggOfGroup(event.target.value);
    setGroupName(event.target.value);

  };


  const handleDateChangeEgg = (date) => {

    setSelectedDate(date);

    const timestamp = date;
  
  const dateObj = new Date(date);
  const day = dateObj.getDate();
  const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
  const year = dateObj.getFullYear();
  
  const formattedDate = `${day}.${month}.${year}`;
  
    setDateOfCollectEggs(formattedDate);
  
  };

  const [selectedTimeOfEgg, setSelectedTime] = useState(null);

  const handdleChangeTime = (selectedTimeOfEgg) => {

      setSelectedTime(selectedTimeOfEgg);

      const formattedTime = selectedTimeOfEgg ? dayjs(selectedTimeOfEgg).format('HH:mm:ss') : '';

      setTimeOfPutEgg(formattedTime);

  }


const buttonToAddEggsOfGroup = (e) => {
    
    e.preventDefault();
    
      const newEggs = {timeOfCollectEggs: timeOfcollectEggs , dateOfCollectEggs: dateOfCollectEggs, groupName: groupName, croud: croud} ;
    
      console.log(newEggs);
    
      fetch("http://localhost:8080/eggsOfGroup/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newEggs)
      
      }).then(() => {
        console.log("New chicken added");
      });
     setShowAlert(true);

    setTimeout(() => {
        setShowAlert(false);
    }, 3000);

    


    }


 useEffect(() => {
    fetch("http://localhost:8080/group/getAll2")
     .then(res => res.json())
     .then(result => {
       setGroup(result);
       });
   }, []);




return(

<Paper elevation={5} style={styles.paperStyle2}>


<h1 style={{ color: "black" }}><u>Eine Gruppe hat neue Eier gelegt</u></h1>

<div style={styles.containerStyle}>



<FormControl fullWidth>

<InputLabel id="demo-dynamic-select-label">Gruppe</InputLabel>

<Select
    labelId="demo-dynamic-select-label"
    id="demo-dynamic-select"
    value={selectedOptionOfEggOfGroup}
    label="Ei der gruppe"
    onChange={handleChangeEggOfGroup}
    sx={{color:'black'}}
> 

{group.map(group => (
<MenuItem key={group.groupID} value={group.groupName}>
{group.groupName}
</MenuItem>
))}
</Select>



</FormControl>

        <Typography id="input-slider" gutterBottom>
            Menge der Eier
        </Typography>

            <Grid item xs>
                <Slider
                    value={typeof value === 'number' ? value : 0}
                    onChange={handleSliderChange}
                    aria-labelledby="input-slider"
                />
            </Grid>
            <Grid item>
                <Input
                    value={value}
                    size="small"
                    onChange={handleInputChange}
                    onBlur={handleBlur}
                    inputProps={{
                        step: 10,
                        min: 0,
                        max: 100,
                        type: 'number',
                        'aria-labelledby': 'input-slider',
                    }}
                />
            </Grid>




<LocalizationProvider dateAdapter={AdapterDayjs}>
<DemoContainer components={['DatePicker']}>
<DatePicker 
label="Sammeltag"
value={selectedDate}
onChange={handleDateChangeEgg}
/>
</DemoContainer>


</LocalizationProvider>

    <LocalizationProvider dateAdapter={AdapterDayjs}>
        <DemoContainer components={['TimePicker']}>
            <TimePicker
                label="Zeit des aufsammelns"
                value={selectedTimeOfEgg}
                onChange={handdleChangeTime}
                ampm={false}
            />
        </DemoContainer>
    </LocalizationProvider>

<Button
    variant="contained"
    color="black" // corrected color
    onClick={buttonToAddEggsOfGroup }


  >

   Eier der Gruppe hinzufügen
</Button>

    {showAlert && (
        <Alert icon={<CheckIcon fontSize="inherit" />} severity="success">
            Jetzt kann meinen Kuchen backen
        </Alert>
    )}
  </div>
  
</Paper>

);

}