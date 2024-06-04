import * as React from 'react';
import TextField from '@mui/material/TextField';
import {  Paper,Button } from '@material-ui/core';
import { useState } from 'react';
import styles from './styles';



export default function FormPropsTextFields() {

    const [groupName, setGroup_name] = useState('');
    const[ group, setGroup] = useState([]);
    const newGroup = { groupName};
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

return(
    
    

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
)
}
