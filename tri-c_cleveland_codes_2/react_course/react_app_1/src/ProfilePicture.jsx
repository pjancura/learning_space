export function ProfilePicture() {
    const picSource = "./src/assets/magpie_1.png"
    const picAlt = "magpie_1.png"

    const handleClick = (e) => e.target.style.display = "none";

    return (
        <img onClick={(e) => handleClick(e)} src={picSource} alt={picAlt} />
    );
}