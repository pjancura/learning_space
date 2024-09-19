export default function Card (props) {

    const statusParagraph = <p className="card-status">{props.status}</p>

    return (
        <div className="card" id={props.id}>
            <div className="card-upper" >
                <img className="card-image" src={props.imageURL} alt="Katie Zaferes" />
                {props.status.length > 0 && statusParagraph}
                
            </div>
            <div className="card-stats">
                <img className="card-star-icon" src="./src/assets/Star 1.png" alt="stars icon" />
                <p className="card-review">
                    <span className="card-rating color-grey">{props.reviewRating} </span>
                    <span className="card-reviews-number color-grey">&#40;{props.numberOfReviews}&#41; </span>
                    <span className="card-country-location">&#183; {props.country}</span>
                </p>
            </div>
            <div className="card-description">
                <p className="card-description-title">{props.title}</p>
                <p><span className="card-price">From ${props.pricePerPerson}</span> / person</p>
            </div>

        </div>
    );
}

