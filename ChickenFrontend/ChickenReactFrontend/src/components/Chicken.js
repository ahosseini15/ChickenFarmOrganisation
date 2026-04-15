import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Box, Paper, Typography, Button } from '@material-ui/core';
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
import { DataGrid } from '@mui/x-data-grid';
import logo from '/home/hali/Development/projects/ChickenfarmProjekt/Studentsystem/studentfrontend/src/components/212acaee1bfbced223ab82b7c6d4de47.gif'




export default function FormPropsTextFields() {

  const [chickenID, setChickenID] = useState('');

  const [chickenName, setChickenName] = useState('');
  const [chickenGender, setChickenGender] = useState('');
  const [chickenDateOfBirth, setChickenDateOfBirth] = useState('');
  const [chickenRace, setChickenRace] = useState('');
  const [chickenGroupName, setChickenGroupName] = useState('');
  
  const [chicken, setChicken] = useState([]);
  

  const [groupName, setGroup_name] = useState(''); 

  const[ group, setGroup] = useState([]);


  const[timeOfPutEgg, setTimeOfPutEgg] = useState('');
  const[size, setSize] = useState('') ; 
  const[ecoID, setEocID] = useState('');


  const buttonToAddGroup = (e) => {
    
  
  e.preventDefault();

  const newGroup = { groupName};

    console.log(newGroup);
    fetch("http://localhost:8080/group/add2", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newGroup),
    }).then(() => {
      console.log("New chicken added");
    });

}

   const buttonToAddChicken = (e) => {
    
    e.preventDefault();

    const newChicken = { chickenName, chickenGender, chickenRace, chickenDateOfBirth, chickenGroupName, chickenID} ;    

    console.log(newChicken);


    fetch("http://localhost:8080/chicken/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newChicken)
    
    }).then(() => {
      console.log("New chicken added");
    });

}


const buttonToAddOneEgg = (e) => {
    
e.preventDefault();

  const newEgg = {timeOfPutEgg, size, chickenName} ;    

  console.log(newEgg);

  fetch("http://localhost:8080/eggOfChicken/add", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(newEgg)
  
  }).then(() => {
    console.log("New chicken added");
    console.log(newEgg)
  });

}

//  Daten von der Datenbank ins Frontend

 useEffect(() => {
    fetch("http://localhost:8080/chicken/getAll")
     .then(res => res.json())
     .then(result => {
       setChicken(result);
       });
   }, []);

   useEffect(() => {
    fetch("http://localhost:8080/group/getAll2")
     .then(res => res.json())
     .then(result => {
       setGroup(result);
       });
   }, []);





const [selectedOption, setSelectedOption] = useState('');
const [selectedOptionOfEggOfChicken, setSelectedOptionOfEggOfChicken] = useState('');


const selectedChickenGroup = event => {
  setSelectedOption(event.target.value);
  setChickenGroupName(event.target.value);
};


const handleChangeEggOfChicken = event => {
  setSelectedOptionOfEggOfChicken(event.target.value);
  setChickenName(event.target.value);
};

const [selectedDate, setSelectedDate] = useState(null);

const handleDateChange = (date) => {
  // Aktualisieren Sie den Zustand mit dem ausgewählten Datum
  setSelectedDate(date);


  const timestamp = date;

const dateObj = new Date(date);
const day = dateObj.getDate();
const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
const year = dateObj.getFullYear();

const formattedDate = `${day}.${month}.${year}`;

  setChickenDateOfBirth(formattedDate);

};


const handleDateChangeEgg = (date) => {
  // Aktualisieren Sie den Zustand mit dem ausgewählten Datum
  setSelectedDate(date);


  const timestamp = date;

const dateObj = new Date(date);
const day = dateObj.getDate();
const month = dateObj.getMonth() + 1; // Monate in JavaScript beginnen mit 0, daher +1 für den korrekten Monat
const year = dateObj.getFullYear();

const formattedDate = `${day}.${month}.${year}`;

  setTimeOfPutEgg(formattedDate);

};


const [Gender, setGender] = React.useState('');

const handleChangeGender = (event) => {
  setGender(event.target.value);
  setChickenGender(event.target.value);
};

const [eggSize, setEggSize] = React.useState('');



const handleChangeEggSize = (event) => {
  setEggSize(event.target.value);
  setSize(event.target.value);
};

    

  return (
 
 
  

    <Box
    component="form"
    sx={{
      display: 'flex',
      flexDirection: 'row', // Elemente nebeneinander anordnen
      gap: 1, // Abstand zwischen den Elementen
      '& .MuiTextField-root': { width: '25ch' },
    }}
    noValidate
    autoComplete="off"
  >



      
      <Paper elevation={15} style={styles.paperStyle}>


 
      <Paper elevation={15} style={styles.paperStyle2}>
 
          <Typography variant="h4" style={{ color: "black", fontFamily: "Arial" }}>
            <ul>In dieser Seite können Sie folgende Daten einpflegen</ul>  
            
        
            <div style={{ 
           // display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            borderRadius: '10px',
            width: '350px',
            height: '200px',
            marginLeft:'200px'
          }}>
            <img src={logo} alt="Beschreibung des GIFs" style={{ maxWidth: '100%', maxHeight: '100%' }} />
          </div>



          </Typography> 
          </Paper>
          <Paper elevation={5} style={styles.paperStyle2}>
          <Typography variant="h5" style={{ color: "black", fontFamily: "Arial" }}>
            <li> Neue Hühner anlegen</li>
            <li>Aktualisieren von Hühnerdaten</li>
            <li>Daten zur Historie von Hühnern</li>
               
          </Typography>  
 
        </Paper>

</Paper>

<Paper elevation={15} style={styles.paperStyle}>

  <Paper elevation={5} style={styles.paperStyle2}>

   <h1 style={{ color: "black" }}><u>Neue Gruppe anlegen</u></h1>

          <div style={styles.containerStyle}> 

 <TextField
              required
              id="chickengroup"
              label="Gruppe"
              defaultValue=""
              value={groupName}
              onChange={(e) => setGroup_name(e.target.value)}
            />

            <Button
              variant="contained"
              color="black" // corrected color
              onClick={buttonToAddGroup }
            >
              Gruppe anlegen
            </Button>

          </div>

        </Paper>



        <Paper elevation={5} style={styles.paperStyle2}>


        <h1 style={{ color: "black" }}><u>Neues Huhn anlegen</u></h1>

        <div style={styles.containerStyle}>



   <FormControl fullWidth>
   
      <InputLabel id="demo-dynamic-select-label">Auswahl</InputLabel>

      <Select
            labelId="demo-dynamic-select-label"
            id="demo-dynamic-select"
            value={selectedOption}
            label="Gruppe"
            onChange={selectedChickenGroup}
            sx={{color:'black'}}
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

{ <TextField
              required
              id="chickenrace"
              label="Rasse"
              defaultValue=""
              value={chickenRace}
              onChange={(e) => setChickenRace(e.target.value)}
            /> }

  
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
            onClick={buttonToAddChicken }
          >
           Huhn anlegen
  </Button>
          
          </div>
          
        </Paper>

</Paper>



<Paper elevation={5} style={styles.paperStyle}>
  <Paper elevation={5} style={styles.paperStyle2}>


  <h1 style={{ color: "black" }}><u>Neues Huhn anlegen</u></h1>

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
  label="Wann wurde das EI gelegt" 
  value={selectedDate}
  onChange={handleDateChangeEgg}
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

</Paper>





        { 
<Paper elevation={5} style={styles.paperStyle}>
          
  <Paper elevation={5} style={styles.paperStyle2}>
          
     <h1>Hhn Eier</h1>
        
    <div style={{ height: 1000, width: '100%', Color: 'black' }}>
 
     <DataGrid 
        columns={[{ field: 'id', headerName: 'ID' }, { field: 'name', headerName: 'Name' }, { field: 'group', headerName: 'Group' },  { field: 'race', headerName: 'Rasse' }, { field: 'gender', headerName: 'Geschlecht' }, { field: 'dateOfBirth', headerName: 'Geburtstag' },]}
        rows={chicken.map((chicken, index) => ({ id: index, name: chicken.chickenName, group: chicken.chickenGroupName, race: chicken.chickenRace, gender: chicken.chickenGender, dateOfBirth: chicken.chickenDateOfBirth  }))}
     />
     
    </div>
     
  </Paper>

  <Paper elevation={5} style={styles.paperStyle2}>

   <h1>Angelegte Gruppen</h1>

    <div style={{ height: 1000, width: '100%' }}>

      <DataGrid 
          columns={[{ field: 'name' }]}
          rows= {group.map((group) => ({ id: group.groupID, name: group.groupName}))}
       />

    </div>

   </Paper>

        </Paper> }
      
    </Box>

  );
  
}







  