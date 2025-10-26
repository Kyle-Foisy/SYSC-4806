function get_AddressBook() {
    let inputValue = $('#id').val();
    let neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}'
    neededURL.replace("${inputValue}", inputValue)
    $.ajax({
        url: neededURL,
        type: 'GET',
    }).then(function(data) {
        $('.addressBookid').append(neededURL)
        $('.addressBookid').append(data.id)
        $.each(data.buddies, function(i, buddy) {
                $('.buddybody').append('<tr>');
                $('.buddybody').append('<td>' + buddy.name + '</td>');
                $('.buddybody').append('<td>' + buddy.phonenumber + '</td>');
                $('.buddybody').append('</tr>');
            }
        )
    })
}

$('#search-AddressBook').on('click', function (
))

$(document).ready(function() {

});