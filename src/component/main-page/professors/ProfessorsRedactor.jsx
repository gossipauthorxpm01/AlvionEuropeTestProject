import UrlsFetch from "../../../UrlsFetch";
import Professor from "./entity/Professor";

function ProfessorsRedactor(props) {

    return <div className={'professor-card-redactor'}>
        <button onClick={downloadReport}>Скачать отчет</button>
        <div className={'form'}>
            <h1>Удалить профессора</h1>
            <input id={'delete-id-form'} placeholder={'ID'} type="number"/>
            <button onClick={deleteProfessor}>Удалить</button>
        </div>
        <div className={'form'}>
            <h1>Добавить профессора</h1>
            <input id={'add-name-form'} placeholder={'ФИО'} type="text"/>
            <input id={'add-address-form'} placeholder={'Адрес'} type="text"/>
            <input id={'add-phoneNumber-form'} placeholder={'Номер телефона'} type="text"/>
            <input id={'add-payment-form'} placeholder={'Заработная плата'} type="text"/>
            <button onClick={addProfessor}>Добавить</button>
        </div>
        <div className={'form'}>
            <h1>Изменить профессора</h1>
            <input id={'change-id-form'} placeholder={'ID профессора'} type="number"/>
            <input id={'change-name-form'} placeholder={'ФИО'} type="text"/>
            <input id={'change-address-form'} placeholder={'Адрес'} type="text"/>
            <input id={'change-phoneNumber-form'} placeholder={'Номер телефона'} type="text"/>
            <input id={'change-payment-form'} placeholder={'Заработная плата'} type="text"/>
            <button onClick={changeProfessor}>Изменить</button>
        </div>
    </div>

    async function downloadReport() {
        await fetch(UrlsFetch.DOWNLOAD_REPORT, {
            method: "POST"
        }).then(res => res.blob()).then(result => {
            console.log(result)
            let url = URL.createObjectURL(result)
            let aLink = document.createElement("a");
            aLink.href = url;
            aLink.download = "excel-report.xlsx";
            aLink.click();
            aLink.remove();
        })
    }

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
                result.text().then(r => alert(r))
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
                result.text().then(r => alert(r))
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



