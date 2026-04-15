import './App.css';
import Appbar from './components/Appbar';
import AddChicken from './components/Chicken';
import AddChicken2 from './components/AddChicken';
import { Box, Paper} from '@material-ui/core';
import styles from './components/styles';
import AddGroup from './components/AddGroup'
import Instructions from './components/Instruktions'
import AddOneEgg from './components/AddOneEgg'
import ShowData from './components/Showdata'
import AddEggGroup from './components/AddEggGroup'
import AddVaccination from './components/AddVaccinationOfOneChicken'
function App() {


  return (
    <div className="App">

      <Box
    component="form"
    sx={{
      display: 'flex',
      flexDirection: 'row',
      gap: 1,
      '& .MuiTextField-root': { width: '25ch' },
    }}
    noValidate
    autoComplete="off"
  >
      <Appbar/>
      <Instructions/>
      <Paper elevation={15} style={styles.paperStyle}>
      <AddChicken2/>
      <AddGroup/>
      </Paper>
      <Paper elevation={15} style={styles.paperStyle}>
       <AddOneEgg/>
       <AddEggGroup/>
      </Paper>

          <Paper elevation={15} style={styles.paperStyle}>
             <AddVaccination/>
          </Paper>

      <ShowData/>

     </Box>

    </div>
  );
}

export default App; 
