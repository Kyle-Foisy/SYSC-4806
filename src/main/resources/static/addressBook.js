

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

function get_AddressBook() {
    let inputValue = $('#id').val();
    let $addressBookSelector = $('.addressBookid');
    let $buddySelector = $('.buddybody');
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}';
    neededURL = neededURL.replace("${inputValue}", inputValue);
    $addressBookSelector.empty();

    $.ajax({
        url: neededURL,
        type: 'GET',
        data: 'book',
        success: function(data) {
            $addressBookSelector.append("Address Book " + data.id);
            $.each(data.buddies, function(i, buddy){
                addRowBuddyTable(buddy.name, buddy.phonenumber);
            })
        },
        error: function () {
            $addressBookSelector.append("ERROR");
        }
    })
}

