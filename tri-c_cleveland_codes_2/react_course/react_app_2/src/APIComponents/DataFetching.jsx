import { useState, useEffect, useRef } from "react";

const BASE_URL = 'https://jsonplaceholder.typicode.com'


export default function DataFetching() {
    const [isLoading, setIsLoading] = useState(false)
    const [error, setError] = useState();
    const [posts, setPosts] = useState([])
    const [page, setPage] = useState(0)
    
    const abortControllerRef = useRef()

    useEffect(() => {
        const fetchPosts = async () => {
            abortControllerRef.current?.abort();
            abortControllerRef.current = new AbortController();
            
            setIsLoading(true)

            try {
                const response = await fetch(`${BASE_URL}/posts?=${page}`,
                    {
                        signal: abortControllerRef.current?.signal,
                    }
                )
                const posts = await response.json()
                setPosts(posts)
            } catch (e){
                if(e.name === "AbortError") {
                    console.log("Fetch aborted")
                    return;
                }
                setError(e)
                alert(e);
            } finally {
                setIsLoading(false)
            }
            
        }

        fetchPosts()
    }, [page])

    if(isLoading) {
        return (
            <div>
                Loading...
            </div>
        )
    }

    if (error) {
        return (
            <div>
                Something went wrong please refresh the page
            </div>
        )
    }

    return (
        <div>
            <h1>Data Fetching in React</h1>
            <button onClick={() => setPage(page + 1)}>Increase Page ({page})</button>
            <ul>
                {posts.map((post) => {
                    return (
                        <li key={post.id}>
                            {post.title}
                        </li>
                    )
                })}
            </ul>
        </div>
    )
}