import UrlsFetch from "../../../UrlsFetch";
import Professor from "./Professor";

function ProfessorsRedactor(props) {

    return <div className={'professor-card-redactor'}>
        <div className={'form'}>
            <h1>Удалить профессора</h1>
            <input id={'delete-id-form'} placeholder={'ID'} type="number"/>
            <button onClick={deleteProfessor}>Удалить</button>
        </div>
        <div className={'form'}>
            <h1>Добавить профессора</h1>
            <input id={'add-name-form'} placeholder={'ФИО'} type="text"/>
            <input id={'add-address-form'} placeholder={'Адрес'} name={'address'} type="text"/>
            <input id={'add-phoneNumber-form'} placeholder={'Номер телефона'} name={'phoneNumber'} type="text"/>
            <input id={'add-payment-form'} placeholder={'Заработная плата'} name={'payment'} type="text"/>
            <button onClick={addProfessor}>Добавить</button>
        </div>
        <div className={'form'}>
            <h1>Изменить профессора</h1>
            <input id={'change-id-form'} placeholder={'ID профессора'} name={'name'} type="text"/>
            <input id={'change-name-form'} placeholder={'ФИО'} name={'name'} type="text"/>
            <input id={'change-address-form'} placeholder={'Адрес'} name={'address'} type="text"/>
            <input id={'change-phoneNumber-form'} placeholder={'Номер телефона'} name={'phoneNumber'} type="text"/>
            <input id={'change-payment-form'} placeholder={'Заработная плата'} name={'payment'} type="text"/>
            <button onClick={changeProfessor}>Изменить</button>
        </div>
    </div>

    async function addProfessor() {
        let name = document.querySelector("#add-name-form");
        let address = document.querySelector("#add-address-form");
        let phoneNumber = document.querySelector("#add-phoneNumber-form");
        let payment = document.querySelector("#add-payment-form");

        let professor = new Professor(name.value, address.value, phoneNumber.value, payment.value);

        await fetch(UrlsFetch.ADD_PROFESSOR, {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                "Accept": "text/html;charset=UTF-8"
            },
            body: JSON.stringify(professor)
        })
        .then(result => {
            result.text().then(r => console.log(r))
        })
        await props.getProfessorsEvent()
    }

    async function deleteProfessor() {
        let id = document.querySelector("#delete-id-form");
        await fetch(UrlsFetch.DELETE_PROFESSOR + id.value, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                "Accept": "text/html;charset=UTF-8"
            }
        })
        .then(result => {
            result.text().then(r => console.log(r))
        })
        await props.getProfessorsEvent()
    }

    async function changeProfessor() {
        let id = document.querySelector("#change-id-form");
        let name = document.querySelector("#change-name-form");
        let address = document.querySelector("#change-address-form");
        let phoneNumber = document.querySelector("#change-phoneNumber-form");
        let payment = document.querySelector("#change-payment-form");
        let professor = new Professor(id.value, name.value, address.value, phoneNumber.value, payment.value);
        await fetch(UrlsFetch.UPDATE_PROFESSOR, {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                "Accept": "text/html;charset=UTF-8"
            },
            body: JSON.stringify(professor)
        })
        await props.getProfessorsEvent();
    }

}

export default ProfessorsRedactor;



