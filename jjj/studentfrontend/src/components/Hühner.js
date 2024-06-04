import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Box, Paper, Typography, Button } from '@material-ui/core';
import { useState, useEffect } from 'react';




    const paperStyle = {
      padding: '20px',
      margin: '100px 300px' ,// Ändere den oberen und unteren Abstand hier
      borderRadius: '30px',
      backgroundColor: '#333333'
    };
    
    const paperStyle2 = {
      padding: '20px',
      margin: '50px auto', // Ändere den oberen und unteren Abstand hier
      borderRadius: '30px',
      backgroundColor: '#CCCCCC'
    };


const containerStyle = {
  display: 'flex',
  flexDirection: 'column',
  gap: '10px',
};

export default function FormPropsTextFields() {


  const [chickenID, setChickenID] = useState('');
  const [ group_name, setGroup_name] = useState(''); 
  const [chickenName, setChickenName] = useState('');
  const [chickenGender, setChickenGender] = useState('');
  const [chickenDateOfBirth, setChickenDateOfBirth] = useState('');
  const [chickenRace, setChickenRace] = useState('');
  
 const [chicken, setChicken] = useState([]);



  const handleClick = (e) => {
    
  e.preventDefault();
  let i = 1;

const newGroup = { group_name};



    console.log(newGroup);
    fetch("http://localhost:8080/group/add2", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newGroup),
    }).then(() => {
      console.log("New chicken added");
    });



     // Chicken Daten übertragung

   // console.log(newChicken);
    //fetch("http://localhost:8080/chicken/add", {
     // method: "POST",
      //headers: { "Content-Type": "application/json" },
     // body: JSON.stringify(newChicken),
    // }).then(() => {
    //  console.log("New Group added");
   // });
    // i++;

}

//TODO
const handleClick2 = (e) => {
    
  e.preventDefault();
  const newChicken = { chickenName, chickenGender, chickenRace, chickenDateOfBirth};    

    console.log(newChicken);
    fetch("http://localhost:8080/group/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newChicken),
    }).then(() => {
      console.log("New chicken added");
    });

}


//  Daten von der Datenbank ins Frontend

  // useEffect(() => {
  //   fetch("http://localhost:8080/chicken/getAll")
  //     .then(res => res.json())
  //     .then(result => {
  //       setChicken(result);
  //     });
  // }, []);




  return (


    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >



      
      <Paper elevation={15} style={paperStyle}>

        <Paper elevation={5} style={paperStyle2}>
          <Typography variant="h3" style={{ color: "black", fontFamily: "Arial" }}>
            <ul>In dieser Seite können Sie folgende Daten einpflegen</ul>
          </Typography>
          <Typography variant="h4" style={{ color: "black", fontFamily: "Arial" }}>
            <li> Neue Hühner anlegen</li>
            <li>Aktualisieren von Hühnerdaten</li>
            <li>Daten zur Historie von Hühnern</li>
          </Typography>
        </Paper>

</Paper>

<Paper elevation={15} style={paperStyle}>

        <Paper elevation={5} style={paperStyle2}>

          <h1 style={{ color: "black" }}><u>Neue Gruppe anlegen</u></h1>


          <div style={containerStyle}> 

<TextField
              required
              id="chickengroup"
              label="Gruppename"
              defaultValue=""
              value={group_name}
              onChange={(e) => setGroup_name(e.target.value)}
            />

            <Button
              variant="contained"
              color="black" // corrected color
              onClick={handleClick }
            >
              Gruppe anlegen
            </Button>

          </div>

        </Paper>



        <Paper elevation={5} style={paperStyle2}>


        <h1 style={{ color: "black" }}><u>Neues Huhn anlegen</u></h1>

        <div style={containerStyle}>

 { <TextField
              required
              id="chickenrace"
              label="Rasse"
              defaultValue=""
              value={chickenRace}
              onChange={(e) => setChickenRace(e.target.value)}
            /> }

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


  { /*
          <TextField
              required
              id="chickengender"
              label="Geschlecht"
              defaultValue=""
              value={chickenGender}
              onChange={(e) => setChickenGender(e.target.value)}
            /> 



        
         */   

  }   
  
  
   <Button
            variant="contained"
            color="black" // corrected color
            onClick={handleClick2 }
          >
           Huhn anlegen
          </Button>
          
          </div>
          
        </Paper>

</Paper>
        
        {  <Paper elevation={5} style={paperStyle}>
          
        <Paper elevation={5} style={paperStyle2}>
          
          <h1>Angelegte Hühner</h1>
          {chicken.map(chicken => (
            <Paper elevation={7} style={paperStyle2} key={chickenID}>
              Name:         {chicken.chickenName} <br />
              Geschlecht:   {chicken.chickenGender} <br />
              Geburtstag:   {chicken.chickenDayOfBirth} <br />
              Rasse:        {chicken.chickenRace}

            </Paper>
          )) }

        </Paper> 
        </Paper> }
      
 
      
    </Box>
  );
}




/*
              onChange  ={(e) => {
        
                let groupName = e.target.value;
          
                setGroupTable(groupName);
                }
              }
            */
            


