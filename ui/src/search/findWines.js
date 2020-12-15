export default async function findWines(query) {
    const response = await fetch(`api/wines?search=${query}`);
    const searchResult = await response.json();
    return searchResult.wines
}
