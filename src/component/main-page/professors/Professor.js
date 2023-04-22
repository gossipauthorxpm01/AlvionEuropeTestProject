class Professor {


    constructor(id = null, name, address, phoneNumber, payment) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.payment = payment;
    }

    name;
    address;
    phoneNumber;
    payment;

}

export default Professor;