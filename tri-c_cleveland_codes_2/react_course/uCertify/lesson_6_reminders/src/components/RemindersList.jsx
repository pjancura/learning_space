import PropTypes from 'prop-types';
import Reminder from './Reminder'

function RemindersList(props){
    const reminders = props.reminders.map((reminder,index)=>{
        console.log(JSON.stringify(reminder))
        return (<Reminder reminderText={reminder.reminderText}
            dueDate={reminder.dueDate}
            isComplete={reminder.isComplete}
            setIsComplete={props.setIsComplete}
            id={index}
            key={index}/>);
      });
    
      return(
          <div>
            {reminders}
          </div>
      );
  }

RemindersList.propTypes = {
    reminders: PropTypes.array,
    setIsComplete: PropTypes.func,
}

const date = new Date();
const formattedDate = date.toISOString().substring(0,10);
RemindersList.defaultProps = {
reminders: [{
    reminderText:"No Reminders Yet",
    dueDate:formattedDate,
    isComplete: false,
}]
}

export default RemindersList; 