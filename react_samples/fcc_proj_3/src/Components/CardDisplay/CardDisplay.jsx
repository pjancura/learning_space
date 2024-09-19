import Card from "../Card/Card"

export default function CardDisplay (props) {

    console.log(props.cardDetails)


    const cards = props.cardDetails.map(details => {
            return (
                <Card 
                    key={details.id}
                    id={details.id} 
                    imageURL={details.imageURL} 
                    status={details.status}
                    reviewRating={details.reviewRating}
                    numberOfReviews={details.numberOfReviews}
                    country={details.country}
                    title={details.title}
                    pricePerPerson={details.pricePerPerson}/>
            );
        })

    return (
        <div className="cardDisplay">
            {cards}
        </div>
    );
}