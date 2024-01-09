use std::io;

pub(crate) fn run_fizz_buzz() {
    // Take user input
    println!("Enter a number: ");
    let mut input = String::new();

    io::stdin()
        .read_line(&mut input)
        .expect("Failed to read line");

    let input: i32 = input.trim().parse().unwrap_or_else(|_| {
        println!("Could not parse number. Defaulting to -1");
        -1
    });

    let mut response: Vec<String> = Vec::new();

    for i in 1..=input {
        let string = get_output_string(&i);

        response.push(string);
    }

    println!("Output: {:?}", response)
}

fn get_output_string(input: &i32) -> String {
    let mut output = String::new();

    if input % 3 == 0 && input % 5 == 0 {
        output.push_str("FizzBuzz")
    } else if input % 3 == 0 {
        output.push_str("Fizz");
    } else if input % 5 == 0 {
        output.push_str("Buzz")
    } else {
        output.push_str(&*input.to_string())
    }

    return output;
}