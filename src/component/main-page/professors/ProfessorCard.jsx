import "./professor.css";
function ProfessorCard(props){
    return <div className={'professor-card'}>
        <h1>ID - {props.id}</h1>
        <span>
            ФИО - <strong>{props.name}</strong>
        </span>
        <span>
            Адрес - {props.address}
        </span>
        <span>
            Номер телефона - <strong>{props.phoneNumber}</strong>
        </span>
        <span>
            Заработная плата - {props.payment}
        </span>
    </div>
}export default ProfessorCard;