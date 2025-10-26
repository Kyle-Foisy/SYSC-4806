function get_AddressBook() {
    let inputValue = $('#id').val();
    let $addressBookSelector = $('.addressBookid')
    let $buddySelector = $('.buddybody')
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}'
    neededURL = neededURL.replace("${inputValue}", inputValue)
    $addressBookSelector.empty()
    $buddySelector.empty()
    $.ajax({
        url: neededURL,
        type: 'GET',
        success: function(data) {
            $addressBookSelector.append("Address Book " + data.id)
            for (var i = 0; i < data.buddies.length; i++) {
                $buddySelector.append('<tr>');
                $buddySelector.append('<td>' + data.buddies[i].name + '</td>');
                $buddySelector.append('<td>' + data.buddies[i].phonenumber + '</td>');
                $buddySelector.append('</tr>');
            }
        },
        error: function () {
            $addressBookSelector.append("ERROR")
        }
    })
}

