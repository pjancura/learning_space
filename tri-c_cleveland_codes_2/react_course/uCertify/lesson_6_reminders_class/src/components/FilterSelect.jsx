import { Component } from 'react'
import PropTypes from 'prop-types';

class FilterSelect extends Component {
  constructor(props){
    super(props);
    this.handleChange = this.handleChange.bind(this)
  }
  
  handleChange = function(e) {
    this.props.setSelectedFilter(e.target.value);
  }
  render() {
    
    return(
      <label htmlFor="filterReminders">Show tasks due:
        <select id="filterReminders" value={this.props.selectedFilter} onChange={this.handleChange}>
          <option value="2day">within 2 Days</option>
          <option value="1week">within 1 Week</option>
          <option value="30days">within 30 days</option>
          <option value="all">any time</option>
        </select>
      </label>
    );
  }
}


FilterSelect.propTypes = {
  selectedFilter: PropTypes.string,
  setSelectedFilter: PropTypes.func
}
 
FilterSelect.defaultProps = {
  selectedFilter:'all'
}
export default FilterSelect;