import { Component } from 'react';
import PropTypes from 'prop-types';

class Reminder extends Component {
  render() {
    const handleChange = () => {
      this.props.setIsComplete(!this.props.isComplete,this.props.id);
    }
    
    return(
      <div className="item" id={this.props.id} key={this.props.key}>
          item: {this.props.reminderText}
        <span className="due-date">due date: {this.props.dueDate}</span>
        <span className="is-complete">
            Completed?: <input type="checkbox"
                           checked={this.props.isComplete}
                           onChange={handleChange}/></span>
      </div>
      );

  }
}
 
Reminder.propTypes = {
  reminderText: PropTypes.string,
  dueDate: PropTypes.string,
  isComplete: PropTypes.bool,
  setIsComplete: PropTypes.func,
  id: PropTypes.number,
  key: PropTypes.number,
}

const date = new Date();
const formattedDate = date.toISOString().substring(0,10);

Reminder.defaultProps = {
  reminderText:"No Reminder Set",
  dueDate:formattedDate,
  isComplete: false,
}

export default Reminder;  