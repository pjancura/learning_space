import { useMemo } from "react"
export const DOTS = '...';

const range = (start, end) => {
    let l = end - start + 1;
    console.log(`FROM RANGE: start: ${start}, end: ${end}, l: ${l}`)
    // Create an arrray of certain length and 
    // set the elements with it from start value to end value
    console.log(`FROM RANGE: ${Array.from(new Array(5), (_, idx) => idx + start)}`)
    return Array.from(new Array(l), (_, idx) => idx + start);
}

export const usePagination = ({
    totalCount,
    pageSize,
    siblingCount = 1,
    currentPage
}) => {
    console.log(totalCount, pageSize, siblingCount, currentPage)
    const paginationRange = useMemo(() => {
        // implementation logic will go here
        const totalPageCount = Math.ceil(totalCount / pageSize);
        // pages count is determined as ciblingCount + firstPage + lastPage + currentPage + 2 * DOTS
        const totalPageNumbers = siblingCount + 5;

        // Case 1: 
        // if the number of pages is less than the page numbers we want to show
        // in out paginationComponent, we return the range [1..totalPageCount]

        if (totalPageNumbers >= totalPageCount) {
            console.log("exited at Case 1")
            return range(1, totalPageCount)
        }

        // calculate left and right sibling index and make sure they are within range
        const leftSiblingIndex = Math.max(currentPage - siblingCount, 1)
        const rightSiblingIndex = Math.min(currentPage + siblingCount, totalPageCount)

        console.log(`leftSiblingIndex: ${leftSiblingIndex}, rightSiblingIndex: ${rightSiblingIndex}`)

        // We do not show dots just when there is just one page number to be inserted 
        // between the extremes of sibling and the page limits i.e 1 and totalPageCount. 
        // Hence we are using leftSiblingIndex > 2 and rightSiblingIndex < totalPageCount - 2
    
        const shouldShowLeftDots = leftSiblingIndex > 2;
        const shouldShowRightDots = rightSiblingIndex < totalPageCount - 2;

        console.log(`shouldShowLeftDots: ${shouldShowLeftDots}, shouldShowRightDots: ${shouldShowRightDots}`)

        const firstPageIndex = 1;
        const lastPageIndex = totalPageCount;

        console.log(`totalPageCount: ${totalPageCount}`)

        // Case 2:
        // No left dots to show, but right dots to be shown

        if (!shouldShowLeftDots && shouldShowRightDots) {
            console.log("exited at Case 2")
            let leftItemCount = 3 + 2 * siblingCount;
            console.log(`leftItemCount ${leftItemCount}`)
            let leftRange = range(1, leftItemCount);
            console.log(`leftRange: ${leftRange}`)

            return [...leftRange, DOTS, totalPageCount]
        }

        // Case3:
        // No right dots to show but left dots to be shown

        if (shouldShowLeftDots && !shouldShowRightDots) {
            let rightItemCount = 3 + 2 * siblingCount
            let rightRange = range(totalPageCount - rightItemCount + 1, totalPageCount)

            return [firstPageIndex, DOTS, ...rightRange]
        }

        // Case 4:
        // Both left and right dots to be shown

        if (shouldShowLeftDots && shouldShowRightDots) {
            let middleRange = range(leftSiblingIndex, rightSiblingIndex)

            return [firstPageIndex, DOTS, ...middleRange, DOTS, lastPageIndex]
        }

    }, [totalCount, pageSize, siblingCount, currentPage])

    console.log(`paginationRange: ${paginationRange}`)

    return paginationRange
}


