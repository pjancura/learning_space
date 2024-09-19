import PropTypes from 'prop-types';

export function List(props) {

    const category = props.category;

    const itemList = props.items;

    // fruits.sort((a, b) => a.name.localeCompare(b.name))
    // fruits.sort((a, b) => b.calories - a.calories);  // NUMERIC SORT

    // const lowCalFruits = fruits.filter(fruit => fruit.calories < 100);  // creates array of fruits with less than 100 calories
    
    const listItems = itemList.map(lowCalFruit => {
       return(<li key={lowCalFruit.id} className="list-item">
             {lowCalFruit.name}: &nbsp;
             {lowCalFruit.calories}
             
             </li>
    )})

    return(
            <>

            <h2 className="list-category">{category}</h2>
            <ol className="list-items">
                {listItems}
            </ol>
            </>
        );
}

List.propTypes = {
    category: PropTypes.string,
    items: PropTypes.arrayOf(PropTypes.shape({id: PropTypes.number,
                                            name: PropTypes.string,
                                            calories: PropTypes.number,}))
}

List.defaultProps = {
    category: "Category",
    items: [],
}