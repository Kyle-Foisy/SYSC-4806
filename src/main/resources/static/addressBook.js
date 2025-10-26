

const $buddy = {
    id: 0,
    name: "",
    phonenumber: 1234567890
}
const $buddies = [$buddy.val()]

const book = {
    id: 0,
    buddies: $buddies.val()
}

// var table = document.getElementById("buddies")

function addRowBuddyTable(name, phonenumber){
    let table = document.getElementById("buddies")
    let row = table.insertRow()
    let cell1 = row.insertCell(0)
    let cell2 = row.insertCell(1)
    cell1.appendChild(document.createTextNode(name))
    cell2.appendChild(document.createTextNode(phonenumber.toString()))
}

function get_AddressBook(){
    let inputValue = $('#id').val();
    get_AddressBook_by_id(inputValue)
}

function display_AddressBook(data){
    let $addressBookSelector = $('.addressBookid');
    $addressBookSelector.empty();
    let table = document.getElementById("buddies");
    let rowCount = table.rows.length
    for (var i = 1; i < rowCount; i++){
        table.deleteRow(1);
    }
    $addressBookSelector.append("Address Book " + data.id);
    $.each(data.buddies, function(i, buddy){
        addRowBuddyTable(buddy.name, buddy.phonenumber);
    })
}


function get_AddressBook_by_id(id) {
    let $addressBookSelector = $('.addressBookid');
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}';
    neededURL = neededURL.replace("${inputValue}", id);

    $.ajax({
        url: neededURL,
        type: 'GET',
        data: 'book',
        success: function(data) {
            display_AddressBook(data);
        },
        error: function () {
            alert("No AddressBook with id: " + id);
        }
    })
}

function addBook() {
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/newbookjs';
    $.ajax({
        url: neededURL,
        type: 'POST',
        data: 'book',
        success: function(data) {
            display_AddressBook(data);
        },
        error: function () {
            alert("Could not create new book!");
        }
    })
}

function addBuddy() {
    let id = $('#id_addbuddy').val();
    let name = $('#name_addbuddy').val();
    let number = $('#number_addbuddy').val();
    let neededURL = `https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/addbuddyjs?id=${id}&name=${name}&phonenumber=${number}`;
    $.ajax({
        url: neededURL,
        type: 'POST',
        success: function(data) {
            display_AddressBook(data);
        },
        error: function () {
            alert("Could not add buddy!");
        }
    })
}



