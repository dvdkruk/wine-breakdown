export default async function fetchWine(lotCode) {
    const response = await fetch(`/api/wines/${lotCode}`);
    return await response.json();
}
