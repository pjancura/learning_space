import * as DATA from "../article.json" assert { type: 'json' }


function printArticle(article) {
    // console.log(article)
    let obj = article.default
    console.log(typeof(obj))
    console.log(obj.title)
    console.log(Object.entries(obj.content))
    for (const [key, value] of Object.entries(obj.content)) {
        console.log(`subheading: ${value.subheading}`)
        let n = 1
        // console.log(value.paragraphs)
        value.paragraphs.forEach(paragraph => {
            console.log(`PARAGRAPH ${n}: ${paragraph}`)
            n++
        })
        console.log("\n")
    }
    // console.log(Object.values(obj))
}

printArticle(DATA)
