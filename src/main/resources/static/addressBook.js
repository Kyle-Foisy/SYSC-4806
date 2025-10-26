

var $buddy = {
    id: 0,
    name: "",
    phonenumber: 1234567890
}
var $buddies = [$buddy.val()]

var book = {
    id: 0,
    buddies: $buddies.val()
}

function get_AddressBook() {
    let inputValue = $('#id').val();
    let $addressBookSelector = $('.addressBookid')
    let buddyTable = document.getElementById('Buddies')
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}'
    neededURL = neededURL.replace("${inputValue}", inputValue)
    $addressBookSelector.empty()
    $buddySelector.empty()
    $.ajax({
        url: neededURL,
        type: 'GET',
        data: "book",
        success: function(data) {
            $addressBookSelector.append("Address Book " + data.id)
            $.each(data.buddies, function(i, buddy){
                let row = buddyTable.insertRow(buddyTable.rows.length)
                let cell1 = row.insertCell(0)
                let cell2 = row.insertCell(1)
                cell1.innerHTML= buddy.name
                cell2.innerHTML = buddy.phonenumber
            })
        },
        error: function () {
            $addressBookSelector.append("ERROR")
        }
    })
}

