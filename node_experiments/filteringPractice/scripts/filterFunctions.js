import plants from "../nativePlants.json" with { type: 'json' }

const data = plants.plants

// below is a sample of the data structure for the plants
// "agastacheScrophulariifolia": {
//             "scientificName": "Agastache scrophulariifolia",
//             "commonName": "Purple giant hyssop",
//             "bloomStart": "July",
//             "bloomEnd": "September",
//             "lifespan": "perennial",
//             "form": "forb",
//             "sunPreference": "full sun, partial sun, full shade",
//             "soilPreference": "dry, moist",
//             "larvalHost": false,
//             "supportsSpecialistBees": false,
//             "attractsBeneficialInsects": true,
//             "bumbleBeePlant": true,
//             "nestSite": false,
//             "nestMaterials": false,
//             "nestThatch": false,
//             "deerResistant": false
//         },

// contain the filter parameters in an object
// each key will match one in the JSON object
let filter = {
    bloomStart: [],
    bloomEnd: [],
    form: [],
    sunPreference: [],
    soilPreference: [],
    larvalHost: [],
    supportsSpeciallistBees: [],
    bumbleBeePlant: [],
    nestSite: [],
    nestMaterials: [],
    nestThatch: [],
    deerResistant: [],
}

const monthMap = new Map()
monthMap.set("january", 1)
monthMap.set("february", 2)
monthMap.set("march", 3)
monthMap.set("april", 4)
monthMap.set("may", 5)
monthMap.set("june", 6)
monthMap.set("july", 7)
monthMap.set("august", 8)
monthMap.set("september", 9)
monthMap.set("october", 10)
monthMap.set("november", 11)
monthMap.set("december", 12)

// this will be used to build the query object
filter = {
    bloomTime:{
            start: ["march"],
            end: ["may"],
        },
    lifespan: [],
    form: [],
    sunPreference: [],
    soilPreference: [],
    larvalHost: [],
    supportsSpeciallistBees: [],
    bumbleBeePlant: [],
    nestSite: [],
    nestMaterials: [],
    nestThatch: [],
    deerResistant: []
}



// this helper function looks at each key in the filter and makes sure that it is of type Array
// if so and the length > 0, it gets added to the query object
const buildFilter = (filter) => {
    let query = new Object ()
    for (let keys in filter) {
        if (filter[keys].constructor === Object || filter[keys].constructor === Array && filter[keys].length > 0) {
            query[keys] = filter[keys]
        }
    }
    console.log(`FILTER OBJECT CREATED:\n\t${JSON.stringify(query)}`)
    return query
}

// buildFilter(filter)


// this utilizes the .filter() method that has a callback
// the callback should return true or false
// if true the item is included in the new array

const handleBloomTime = (start, end, key) => {
    // console.log(data, key[0])
    let keyStartMonthInt = monthMap.get(key['start'].toLowerCase())
    let keyEndMonthInt = monthMap.get(key['end'].toLowerCase())
    let startMonthInt = monthMap.get(start.toLowerCase())
    let endMonthInt = monthMap.get(end.toLowerCase())
    console.log(keyMonthInt, dataMonthInt)
    if (keyStartMonthInt !== undefined && startMonthInt < keyStartMonthInt) {
        return false
    }
    if (keyEndMonthInt !== null && endMonthInt > keyEndMonthInt) {
        return false
    }

}


const filterData = (data, query) => {
    const filteredData = Object.values(data).filter( (item) => {
        for (let key in query) {
            let values = item[key]
            if (typeof(values) === "boolean") {
                if (values === undefined || !query[key].includes(values)) {
                    return false;
                }
            }
            else if (key.includes("bloom")) {
                return handleBloomTime(item['bloomStart'], item['bloomEnd'], query[key])
            }
            else if (values.includes(",")){
                values = item[key].replaceAll(" ", "").split(",")
                query[key].forEach(queryValue =>  {
                    // console.log(values, queryValue, !values.includes(queryValue))
                    if (!values.includes(queryValue)) {
                        // console.log("RETURNED FALSE")
                        return false
                    }
                })
            }
            else {
                    // console.log(values, query[key], !query[key].includes(values))
                    if (values === undefined || !query[key].includes(values)) {
                    // console.log("RETURNED FALSE")
                    return false;
                }
            }
        }
        // console.log("RETURNED TRUE")
        return true;
    })
    console.log(`FILTERED DATA: ${filteredData.length}`)
    filteredData.forEach(item => {
        console.log(JSON.stringify(item))
    })
    return filteredData
}

// buildFilter(filter)



filterData(data, buildFilter(filter))


