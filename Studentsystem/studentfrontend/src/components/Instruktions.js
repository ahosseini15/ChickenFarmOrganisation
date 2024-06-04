import * as React from 'react';

import { Box, Paper, Typography, Button } from '@material-ui/core';
import styles from './styles';
import logo from '/home/hali/Development/projects/ChickenfarmProjekt/Studentsystem/studentfrontend/src/components/212acaee1bfbced223ab82b7c6d4de47.gif'


export default function FormPropsTextFields() {
    
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
</Box>

);
}
