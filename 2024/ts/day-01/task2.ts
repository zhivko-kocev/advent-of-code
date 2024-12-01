const first: number[] = [];
const second: number[] = [];

for await (const line of console) {
  if (line.length == 0) break;

  const pair = line.split(/\s+/);

  first.push(parseInt(pair[0]));
  second.push(parseInt(pair[1]));
}

first.sort((a, b) => a - b);
second.sort((a, b) => a - b);

const occur = new Map<number, number>();
first.forEach((num1) => {
  if (!occur.has(num1)) {
    occur.set(num1, second.filter((num) => num == num1).length);
  }
});

console.log(
  occur
    .entries()
    .map((entry) => entry[0] * entry[1])
    .reduce((accumulator, currentValue) => accumulator + currentValue, 0)
);
