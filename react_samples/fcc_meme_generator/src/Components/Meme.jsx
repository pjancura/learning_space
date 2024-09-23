import { useEffect, useState } from "react";
import GeneratedMeme from "./GeneratedMeme";

export default function Meme() {
    const [meme, setMeme] = useState({
        imageURL: "",
        topText: "",
        bottomText: "",
    })

    const [allMeme, setAllMeme] = useState([])

    function createMeme() {
        getMemeImage();
        generateMeme(meme);
        // setMeme(m => {
        //     return ({
        //         ...m,
        //         topText: "",
        //         bottomText: "",
        //     })
        // })
    }

    useEffect(() => {
        fetch("https://api.imgflip.com/get_memes")
            .then(res => res.json())
            .then(data => setAllMeme(data.data.memes))
            // .then(console.log(allMeme))
    }, [])
    

    function getMemeImage() {
        const randomNumber = Math.floor(Math.random() * allMeme.length);
        setMeme(m => {
            return ({
                    ...m,
                    imageURL: allMeme[randomNumber].url,
            });
        })
    }

    function handleTextChange(e) {
        // e.target.id === "top-text" ? console.log("change in top text") : console.log("change in bottom text");
        setMeme(m => {
            // console.log(e.target.id, e.target.value)
            return ({
                ...m,
                [e.target.name]: e.target.value,

            })
        })
    }

    function generateMeme(m) {
        return (
            <GeneratedMeme memeDetails={m} />
        )
    }


    return (
        <>
        <div className="meme-generator-form">
            <div>
                <label htmlFor="">Top Text</label>
                <input type="text" id="top-text" name="topText" onChange={(handleTextChange)} value={meme.topText}/>
            </div>
            <div>
                <label htmlFor="">Bottom Text</label>
                <input type="text" id="bottom-text" name="bottomText" onChange={(handleTextChange)} value={meme.bottomText}/>
            </div>
            <button className="meme-generator-button" onClick={createMeme}>Get New Meme Image 🌅</button>
        </div>
        <div className="output">
            {meme.imageURL && generateMeme(meme)}
        </div>
        </>
    );
}