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
    }).then(function(data) {
        $addressBookSelector.append(data.id)
        $.each(data.buddies, function(i, buddy) {
            $buddySelector.append('<tr>');
            $buddySelector.append('<td>' + buddy.name + '</td>');
            $buddySelector.append('<td>' + buddy.phonenumber + '</td>');
            $buddySelector.append('</tr>');
            }
        )
    })
}

