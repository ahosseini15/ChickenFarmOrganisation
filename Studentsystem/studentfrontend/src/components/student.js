import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button, Modal} from '@material-ui/core';


//Design Vorlage
const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));





// Studenten Textfeld und eingabe

export default function Student() {



    const paperStyle={padding:'50px 20px', width:600,margin:"10px "}

    const[name,setName]=useState('')
    const[adress,setAdress]=useState('')
    const[students,setStudents]=useState([])
    
     const classes = useStyles();

     //Studenten hinzufügen 
  const handleClick=(e)=>{
    e.preventDefault()
    const student={name,adress}
    console.log(student)
    fetch("http://localhost:8080/student/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("New Student added")
  })
}



useEffect(()=>{
  fetch("http://localhost:8080/student/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])
  return (

    // Design 
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add Student</u></h1>
  
    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Student Name" variant="outlined" 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Student Adress" variant="outlined" 
      value={adress}
      onChange={(e)=>setAdress(e.target.value)}
      />


      <Button variant="contained" color="secondary" onClick={handleClick}>
  Submit
</Button>


    </form>
  



     </Paper>
    <h1>Students</h1>

    <Paper elevation={3} style={paperStyle}>





      {students.map(student=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
         Id:{student.id}<br/>
         Name:{student.name}<br/>
         Address:{student.adress}

        </Paper>

      ))
}








    </Paper>



    </Container>
  );
}