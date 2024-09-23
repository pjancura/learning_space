export default function GeneratedMeme(props) {
    return (
        <div className="generated-meme">
            <img src={props.memeDetails.imageURL} alt="" />
            <p className="top-text">{props.memeDetails.topText}</p>
            <p className="bottom-text">{props.memeDetails.bottomText}</p>
        </div>
    )
}