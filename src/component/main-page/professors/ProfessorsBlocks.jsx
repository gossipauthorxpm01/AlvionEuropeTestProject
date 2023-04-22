import ProfessorCard from "./ProfessorCard";

function ProfessorsBlocks(props) {

    return <div className={'professor-card-block'}>
        <div>
            <h1>Список профессоров</h1>
        </div>
        <div className={'professor-card-list'}>
            {props.professors.map((item) => <ProfessorCard key={item.id}
                                                     id={item.id}
                                                     name={item.name}
                                                     address={item.address}
                                                     phoneNumber={item.phoneNumber}
                                                     payment={item.payment}
                />
            )}
        </div>
    </div>
}

export default ProfessorsBlocks;