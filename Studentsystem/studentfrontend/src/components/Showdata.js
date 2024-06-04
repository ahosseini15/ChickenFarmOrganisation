import * as React from 'react';
import { Paper} from '@material-ui/core';
import { useState, useEffect } from 'react';
import styles from './styles';
import { DataGrid } from '@mui/x-data-grid';


export default function FormPropsTextFields() {



    const [chicken, setChicken] = useState([]);
    const [group, setGroup] = useState([]);
    const[ eggOfChicken, setEggOfChicken] = useState([]);
    const[eggsOfGroup, setEggsOfGroup] = useState([]);
    const[vaccinationOfChicken, setVaccinationOfChicken] = useState([]);


  
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

       useEffect(() => {
        fetch("http://localhost:8080/eggOfChicken/getAll")
         .then(res => res.json())
         .then(result => {
           setEggOfChicken(result);
           });
       }, []);


    useEffect(() => {
        fetch("http://localhost:8080/eggsOfGroup/getAll")
            .then(res => res.json())
            .then(result => {
                setEggsOfGroup(result);
            });
    }, []);

    useEffect(() => {
        fetch("http://localhost:8080/vaccinationOfOneChicken/getAll")
            .then(res => res.json())
            .then(result => {
                setVaccinationOfChicken(result);
            });
    }, []);

       return(
        
        <><Paper elevation={5} style={styles.paperStyle}>

            <Paper elevation={5} style={styles.paperStyle2}>


               <h1> Angelegte Hühner</h1>

               <div style={{ height: 1000, width: '100%', Color: 'black' }}>

                   <DataGrid
                       columns={[{ field: 'id', headerName: 'ID' }, { field: 'name', headerName: 'Name' }, { field: 'chickenDateOfDeath', headerName: 'Gruppe' }, { field: 'race', headerName: 'Rasse' }, { field: 'gender', headerName: 'Geschlecht' }, { field: 'dateOfBirth', headerName: 'Geburtstag' }, {field: 'chickeGroupName', headerName: 'Todeszeitpunkt(leer = lebt)' }]}
                       rows={chicken.map((chicken, index) => ({ id: index, name: chicken.chickenName, chickenDateOfDeath: chicken.chickenDateOfDeath, race: chicken.chickenRace, gender: chicken.chickenGender, dateOfBirth: chicken.chickenDateOfBirth, chickenGroupName: chicken.chickenGroupName }))} />

               </div>

               </Paper>

               <Paper elevation={5} style={styles.paperStyle2}>

               <h1>Angelegte Gruppen</h1>

               <div style={{ height: 1000, width: '100%' }}>

                   <DataGrid
                       columns={[{ field: 'name' }]}
                       rows={group.map((group) => ({ id: group.groupID, name: group.groupName }))} />

               </div>

             </Paper>
           </Paper>
           

           <Paper elevation={5} style={styles.paperStyle}>

           <Paper elevation={5} style={styles.paperStyle2}>


                   <h1>Gelegte Eier</h1>

                   <div style={{ height: 1000, width: '100%' }}>

                       <DataGrid
                           columns={[{ field: 'id' }, { field: 'dateOfPutEgg', headerName: 'Datum' },{field: 'chickenName', headerName: 'Zeitpunkt'},{field: 'timeOfPutEgg', headerName:'Huhn'}, { field: 'size', headerName: 'Größe' }]}
                           rows={eggOfChicken.map((eggOfChicken, index) => ({ id: index, dateOfPutEgg: eggOfChicken.dateOfPutEgg,  chickenName: eggOfChicken.chickenName,  timeOfPutEgg: eggOfChicken.timeOfPutEgg , size: eggOfChicken.size }))} />

                   </div>

</Paper>

               <Paper elevation={5} style={styles.paperStyle2}>


                   <h1>Gelegte Eier der Gruppe</h1>

                   <div style={{height: 1000, width: '100%'}}>

                       <DataGrid
                           columns={[{field: 'id'}, {
                               field: 'dateOfCollectEggs',
                               headerName: 'Datum'
                           }, {field: 'timeOfCollectEggs', headerName: 'Zeitpunkt'}, {
                               field: 'groupName',
                               headerName: 'Gruppe'
                           }, {field: 'croud', headerName: 'Menge'}]}

                           rows={eggsOfGroup.map((eggsOfGroup, index) => ({
                               id: index,
                               dateOfCollectEggs: eggsOfGroup.timeOfCollectEggs,
                               groupName: eggsOfGroup.groupName,
                               timeOfCollectEggs: eggsOfGroup.dateOfCollectEggs,
                               croud: eggsOfGroup.croud
                           }))}/>

                   </div>


               </Paper>

           </Paper>

            <Paper elevation={5} style={styles.paperStyle}>

                <Paper elevation={5} style={styles.paperStyle2}>


                    <div style={{height: 1000, width: '100%'}}>

                        <DataGrid
                            columns={[
                                {field: 'id'},
                                {field: 'dateOfVaccination', headerName: 'Datum'},
                                {field: 'timeOfVaccination', headerName: 'Wirktstoff'},
                                {field: 'chickenName', headerName: 'Huhn'},
                                {field: 'crowdOfVaccination', headerName: 'Zeitpunkt'},
                                {field: 'activeIngredient', headerName: 'Menge'},
                            ]}
                        rows={vaccinationOfChicken.map((vaccinationOfChicken, index) => ({
                            id: index,
                            dateOfVaccination: vaccinationOfChicken.dateOfVaccination,
                            chickenName: vaccinationOfChicken.chickenName,
                            timeOfVaccination: vaccinationOfChicken.timeOfVaccination,
                            crowdOfVaccination: vaccinationOfChicken.crowdOfVaccination,
                            activeIngredient: vaccinationOfChicken.activeIngredient

                         }))}
                        />
        </div>


        </Paper>

    </Paper></>

       );


}