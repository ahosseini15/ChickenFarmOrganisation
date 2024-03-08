import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Box, Paper, Typography, Button } from '@material-ui/core';
import { useState, useEffect } from 'react';

const paperStyle = {
  padding: '20px',
  margin: '300px',
  marginTop: '30px',
  borderRadius: '30px',
  backgroundColor: '#333333'
};

const paperStyle2 = {
  padding: '20px',
  margin: '10px',
  marginTop: '30px',
  borderRadius: '30px',
  backgroundColor: '#CCCCCC'
};

const containerStyle = {
  display: 'flex',
  flexDirection: 'column',
  gap: '10px',
};

export default function FormPropsTextFields() {
  const [ group_name, setGroup_name] = useState(''); 
  const [chickenname, setChickenname] = useState('');
  const [chickengender, setChickengender] = useState('');
  const [chickenbirthdate, setChickenbirthdate] = useState('');
  const [chickenrace, setChickenrace] = useState('');
  const [chickenid, setChickenid] = useState('');   
  const [chicken, setChicken] = useState([]);










  const handleClick = (e) => {



    
  e.preventDefault();
  let i = 1;



  const newChicken = { chickenname, chickengender, chickenbirthdate, chickenrace, chickenid };    
const newGroup = { group_name};



    console.log(newChicken);
    fetch("http://localhost:8080/chicken/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newChicken),
    }).then(() => {
      console.log("New Group added");
    });
    i++;


    console.log(newGroup);
    fetch("http://localhost:8080/group/add2", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newGroup),
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




  return (
    <Box
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >


      /*
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


        <Paper elevation={5} style={paperStyle2}>
          <h1 style={{ color: "black" }}><u>Neues Huhn anlegen</u></h1>
          <div style={containerStyle}> 
                       <TextField
              required
              id="chickenGroup"
              label="Gruppe"
              defaultValue=""
              value={group_name}
              onChange={(e) => setGroup_name(e.target.value)}

            />
            <TextField
              required
              id="chickename"
              label="Name vom Huhn"
              defaultValue="MusterHuhn"
              value={chickenname}
              onChange={(e) => setChickenname(e.target.value)}
            />
            <TextField
              required
              id="chickengender"
              label="Geschlecht"
              defaultValue=""
              value={chickengender}
              onChange={(e) => setChickengender(e.target.value)}
            />
            <TextField
              required
              id="chickenbirthdate"
              label="Gebutsdatum"
              value={chickenbirthdate}
              onChange={(e) => setChickenbirthdate(e.target.value)}
            />
            <TextField
              required
              id="chickenrace"
              label="Rasse"
              defaultValue=""
              value={chickenrace}
              onChange={(e) => setChickenrace(e.target.value)}
            />





            <Button
              variant="contained"
              color="black" // corrected color
              onClick={handleClick }
            >
              Add Chicken
            </Button>



          </div>
        </Paper>
        <Paper elevation={5} style={paperStyle2}>
          <h1>Angelegte Hühner</h1>
          {chicken.map(chicken => (
            <Paper elevation={7} style={paperStyle2} key={chickenid}>
              Id:           {chicken.chickenid} <br />
              Name:         {chicken.chickenname} <br />
              Geschlecht:   {chicken.chickengender} <br />
              Geburtstag:   {chicken.chickenbirthdate} <br />
              Rasse:        {chicken.chickenrace}
            </Paper>
          ))}
        </Paper>
      </Paper>
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
            