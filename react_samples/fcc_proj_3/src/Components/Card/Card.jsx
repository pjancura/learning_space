export default function Card (props) {

    const statusParagraph = <p className="card-status">{props.details.status}</p>

    return (
        <div className="card" id={props.details.id}>
            <div className="card-upper" >
                <img className="card-image" src={props.details.imageURL} alt="Katie Zaferes" />
                {props.details.status.length > 0 && statusParagraph}
                
            </div>
            <div className="card-stats">
                <img className="card-star-icon" src="./src/assets/Star 1.png" alt="stars icon" />
                <p className="card-review">
                    <span className="card-rating color-grey">{props.details.reviewRating} </span>
                    <span className="card-reviews-number color-grey">&#40;{props.details.altnumberOfReviews}&#41; </span>
                    <span className="card-country-location">&#183; {props.details.country}</span>
                </p>
            </div>
            <div className="card-description">
                <p className="card-description-title">{props.details.title}</p>
                <p><span className="card-price">From ${props.details.pricePerPerson}</span> / person</p>
            </div>

        </div>
    );
}

