import Magpie_1 from './assets/magpie_1.png';

export function Card() {
    return (
        <div className="card">
            <img className="card-image" src={Magpie_1} alt="magpie_1.png" width="250"/>
            <h2 className="card-title">Fingersmasher</h2>
            <p  className="card-text">Type in what you do for fun</p>
        </div>
    );
}