import FeedCard from "./FeedCard";


export default function Feed(props) {

    const hr = <hr className="feed-hr"/>
    const len = props.places.length

    const cards = props.places.map(place => {
        let index = props.places.indexOf(place);

        return (
            <div key={place.id}>
                <FeedCard
                place={place}
                />
                {index != len - 1 ? hr : null}
            </div>
        );
    })

    return (
        <div className="feed">
            {cards}
        </div>
    );
}