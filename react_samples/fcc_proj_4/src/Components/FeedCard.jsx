export default function FeedCard(props) {
    return (
        <div className="feed-card">
            <img src={props.place.imageURL} alt="" />
            <div className="feed-card-details">
                <p className="feed-card-details-geo-info">
                    <img src="./src/assets/location_pin_2.png" alt="location_pin.png" />
                    <span className="feed-card-details-country">{props.place.country}</span>
                    <a className="feed-card-details-google-hyperlink" href={props.place.googleMapsHyperlink}>View on Google Maps</a>
                </p>
                <h2 className="feed-card-details-title">{props.place.title}</h2>
                <p className="feed-card-details-dates">{props.place.datesVisited}</p>
                <p className="feed-card-details-description">{props.place.description}</p>
            </div>
        </div>
    );
}


